package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {
	
	public static void main(String[] args) {
		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("contas");
		
		EntityManager createEntityManager = em.createEntityManager();
		
		em.close();
		
	}

}
