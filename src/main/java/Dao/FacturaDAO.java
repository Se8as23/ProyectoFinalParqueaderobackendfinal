package Dao;

import java.io.Serializable;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import modelo.Factura;
import modelo.Ticket;

@Stateless
public class FacturaDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Factura factura) {
		em.persist(factura);
	}
	
	public void update(Factura factura) {
		em.merge(factura);
	}
	
	public Factura read(int codigo) {
		Factura fa = em.find(Factura.class, codigo);
		return fa;
	}
	
	public void delete(int codigo) {
		Factura fa = em.find(Factura.class, codigo);
		em.remove(fa);
	}
	
	public List<Factura> getAll(){
		String jpql = "SELECT fa FROM Factura fa";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	public Factura getByCodigo(int codigo) {
        String jpql = "SELECT p FROM Factura p WHERE p.codigo = :codigo";
        TypedQuery<Factura> query = em.createQuery(jpql, Factura.class);
        query.setParameter("codigo", codigo);

        List<Factura> results = query.getResultList();
        if (results.isEmpty()) {
            return null; // Devolver null cuando no se encuentra ninguna persona
        } else {
            return results.get(0); // Devolver la primera persona encontrada
        }
    }
}
