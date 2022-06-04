package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Employee;

public class EmployeeDao {
	
	public Employee saveEmployee(Employee employee) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		if(employee != null) {
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
			return employee;
		}
		return employee;
	}
}
