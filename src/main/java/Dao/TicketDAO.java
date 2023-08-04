package Dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import modelo.Ticket;
import modelo.Vehiculo;

@Stateless
public class TicketDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	private Ticket t;
	
	public void insert(Ticket ticket) {
		em.persist(ticket);
	}
	
	public void update(Ticket ticket) {
		em.merge(ticket);
	}
	
	public Ticket read(int codigo) {
		Ticket ti = em.find(Ticket.class, codigo);
		return ti;
	}
	
	public void delete(int codigo) {
		Ticket ti = em.find(Ticket.class, codigo);
		em.remove(ti);
	}
	
	public List<Ticket> getAll(){
		String jpql = "SELECT ti FROM Ticket ti";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	public Ticket getByCodigo(int codigo) {
        String jpql = "SELECT p FROM Ticket p WHERE p.codigo = :codigo";
        TypedQuery<Ticket> query = em.createQuery(jpql, Ticket.class);
        query.setParameter("codigo", codigo);

        List<Ticket> results = query.getResultList();
        if (results.isEmpty()) {
            return null; // Devolver null cuando no se encuentra ninguna persona
        } else {
            return results.get(0); // Devolver la primera persona encontrada
        }
    }
	
	
	public double CalcularTotal(Ticket t) {
		
		this.t = t;
		String hora1 = t.getHoraSalida().toString().substring(12, 17);
		String hora2 = t.getHoraEntrada().toString().substring(12, 17);
		
		float tarifa = (float) 0.10;
		
		int hora1ent = Integer.parseInt(hora1);
		int hora2ent = Integer.parseInt(hora2);
		
		double horasresta = hora1ent-hora2ent;
		double total = horasresta*tarifa;
		return total;
	}
	
	public static int calcularHorasEstacionado(Date horaEntrada, Date horaSalida) {
        long diferenciaMillis = horaSalida.getTime() - horaEntrada.getTime();
        int horasEstacionado = (int) (diferenciaMillis / (1000L * 60 * 60));
        
        if (diferenciaMillis % (1000L * 60 * 60) > 0) {
            horasEstacionado++;
        }
		return horasEstacionado;
	}
}
