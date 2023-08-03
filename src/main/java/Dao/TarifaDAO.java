package Dao;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import modelo.Tarifa;
import modelo.Ticket;

@Stateless
public class TarifaDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Tarifa tarifa) {
		em.persist(tarifa);
	}
	
	public void update(Tarifa tarifa) {
		em.merge(tarifa);
	}
	
	public Tarifa read(int codigo) {
		Tarifa ta = em.find(Tarifa.class, codigo);
		return ta;
	}
	
	public void delete(int codigo) {
		Tarifa ta = em.find(Tarifa.class, codigo);
		em.remove(ta);
	}
	
	public List<Tarifa> getAll(){
		String jpql = "SELECT ta FROM Tarifa ta";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
