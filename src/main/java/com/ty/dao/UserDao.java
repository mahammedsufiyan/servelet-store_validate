package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.annotation.WebServlet;

import com.ty.dto.User;

public class UserDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public User saveUser(User user) {
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}
	
	public User validateUser(String email, String password) {
	
		String hql = "Select u from User u where u.email=?1 and u.password=?2";
		Query  query = entityManager.createQuery(hql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<User> user = query.getResultList();
		if(user.size()>0) {
			
			return user.get(0);
		}
		return null;
	}
}
