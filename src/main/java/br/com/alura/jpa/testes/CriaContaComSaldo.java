package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Juliano");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(new Double(500.25));
		
		//pego uma transacao para executar o escopo da tarefa
		em.getTransaction().begin();
		
		em.persist(conta);
		
		//gravo mas em caso de erro eu consigo dar um rollback.
		em.getTransaction().commit();
		
	}


}
