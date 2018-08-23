package co.grandcircus.coffeeshop.dao;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.User;




@Repository
@Transactional
public class UserDaoHibernate {
	
	@PersistenceContext
	EntityManager em;

	
	public List<User> findAll(){
		return em.createQuery("FROM User", User.class).getResultList();
	}
	
	public User findById(Long id) {
		return em.find(User.class, id);
	}
	
	public void create(User user) {
		em.persist(user);
	}
	
	public void delete(Long id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}
	
}
