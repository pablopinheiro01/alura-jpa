package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraContaTarles {
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		EntityManager em = emf.createEntityManager();
		
		Conta contaDoTarles=em.find(Conta.class, 1L);
		
		System.out.println("Titular da conta: " + contaDoTarles.getTitular());
		
		em.getTransaction().begin();
		//alteramos o estado somente no modelo
		contaDoTarles.setSaldo(40.0);
		em.getTransaction().commit();
		
		//Posso utilizar o mecanismo tambem do persist para executar a mesma trasnformacao
		//tambem pode ser incluido o persist para refletir essa alteracao
		//quando eu seto o persist eu transformo minha conta no estado managed
		//em.persist(contaDoTarles);
		
		
	}


}
