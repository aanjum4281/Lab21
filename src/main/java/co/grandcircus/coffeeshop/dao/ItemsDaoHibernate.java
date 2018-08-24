package co.grandcircus.coffeeshop.dao;




import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
	
	public List<Items> findByKeyword(String keyword) {
		// HQL queries can have named parameters, such as :regex here.
		return em.createQuery("FROM Food WHERE LOWER(name) LIKE :regex", Items.class)
				.setParameter("regex", "%" + keyword.toLowerCase() + "%")
				.getResultList();
	}
	
	public List<Items> findByCategory(String category) {
		return em.createQuery("FROM Items WHERE LOWER(category) = :category", Items.class)
				.setParameter("category", category.toLowerCase())
				.getResultList();
	}
	
	public void delete(Long id) {
		Items items = em.getReference(Items.class, id);
		em.remove(items);
	}
	
	public void update(Items items) {
		em.merge(items);
	}
	
	public Set<String> findAllCategories() {
		List<String> categoryList = em.createQuery("SELECT DISTINCT category FROM ITEMS", String.class)
				.getResultList();
		return new TreeSet<>(categoryList);
	}
	
	
}
