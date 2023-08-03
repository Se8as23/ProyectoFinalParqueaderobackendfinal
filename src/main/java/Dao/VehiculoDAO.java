package Dao;

import java.io.Serializable;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import modelo.Vehiculo;
import modelo.Vehiculo;

@Stateless
public class VehiculoDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) {
		em.merge(vehiculo);
	}
	
	public Vehiculo read(int codigo) {
		Vehiculo c = em.find(Vehiculo.class, codigo);
		return c;
	}
	
	public void delete(int codigo) {
		Vehiculo c = em.find(Vehiculo.class, codigo);
		em.remove(c);
	}
	
	public List<Vehiculo> getAll(){
		String jpql = "SELECT c FROM Vehiculo c";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	
    public Vehiculo getByCodigo(int codigo) {
        String jpql = "SELECT p FROM Vehiculo p WHERE p.codigo = :codigo";
        TypedQuery<Vehiculo> query = em.createQuery(jpql, Vehiculo.class);
        query.setParameter("codigo", codigo);

        List<Vehiculo> results = query.getResultList();
        if (results.isEmpty()) {
            return null; // Devolver null cuando no se encuentra ninguna persona
        } else {
            return results.get(0); // Devolver la primera persona encontrada
        }
    }
}

