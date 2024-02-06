package ec.edu.ups.ppw63.examenloja.dao;

import java.util.List;

import ec.edu.ups.ppw63.examenloja.model.Operador;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class OperadorDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Operador operador) {
		em.persist(operador);
		
	}
	
	public void update(Operador operador) {
		em.merge(operador);
			
	}
	
	public void remove(int codigo) {
		Operador operador = em.find(Operador.class, codigo);
		em.remove(operador);
		
	}
	
	public Operador read (int codigo) {
		Operador operador = em.find(Operador.class, codigo);
		
		return operador;
		
	}
	
	public List<Operador> getAll(){
		String jpql = "SELECT c FROM Operador c";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Operador.class);
		return q.getResultList();
	}
}
