package Dao;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import modelo.Sitio;

@Stateless
public class SitioDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Sitio sitio) {
		em.persist(sitio);
	}
	
	public void update(Sitio sitio) {
		em.merge(sitio);
	}
	
	public Sitio read(int codigo) {
		Sitio s = em.find(Sitio.class, codigo);
		return s;
	}
	
	public void delete(int codigo) {
		Sitio s = em.find(Sitio.class, codigo);
		em.remove(s);
	}
	
	public List<Sitio> getAll(){
		String jpql = "SELECT s FROM Sitio s";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	
}
