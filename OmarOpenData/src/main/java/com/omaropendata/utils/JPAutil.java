package com.omaropendata.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@ApplicationScoped
public class JPAutil {
	
	private static EntityManagerFactory factory;
	private  static EntityManager entityManager;

	public static EntityManager getEntityManager(String persistUnit) {
		
		if (entityManager==null)
		{
			factory =  Persistence.createEntityManagerFactory(persistUnit);
			
		  entityManager =
			  factory.createEntityManager();
		}
		  
		return entityManager;
	}
}
