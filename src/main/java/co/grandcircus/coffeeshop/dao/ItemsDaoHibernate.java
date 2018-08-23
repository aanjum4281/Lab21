package co.grandcircus.coffeeshop.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.Items;



@Repository
@Transactional
public class ItemsDaoHibernate {
	@PersistenceContext
	EntityManager em;


	
	public List<Items> findAll(){

	return em.createQuery("FROM Items", Items.class).getResultList();
	}
	
	
	public Items findById(Long id) {
		return em.find(Items.class, id);
	}
	
	public void create(Items items) {
		em.persist(items);
	}
	
	public void delete(Long id) {
		Items items = em.getReference(Items.class, id);
		em.remove(items);
	}
	
	
}
