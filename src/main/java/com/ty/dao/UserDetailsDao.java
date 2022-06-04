package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.UserDetails;

public class UserDetailsDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
			
	
	public UserDetails saveUserDetails(UserDetails details) {
		
		entityTransaction.begin();
		entityManager.persist(details);
		entityTransaction.commit();
		return details;
	}
}
