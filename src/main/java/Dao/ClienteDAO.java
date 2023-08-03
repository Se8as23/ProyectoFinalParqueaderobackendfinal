package Dao;

import java.io.Serializable;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import modelo.Cliente;

@Stateless
public class ClienteDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}
	
	public Cliente read(int codigo) {
		Cliente c = em.find(Cliente.class, codigo);
		return c;
	}
	
	public void delete(int codigo) {
		Cliente c = em.find(Cliente.class, codigo);
		em.remove(c);
	}
	
	public List<Cliente> getAll(){
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	
    public Cliente getByCedula(String cedula) {
        String jpql = "SELECT p FROM Cliente p WHERE p.cedula = :cedula";
        TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
        query.setParameter("cedula", cedula);

        List<Cliente> results = query.getResultList();
        if (results.isEmpty()) {
            return null; // Devolver null cuando no se encuentra ninguna persona
        } else {
            return results.get(0); // Devolver la primera persona encontrada
        }
    }
}
