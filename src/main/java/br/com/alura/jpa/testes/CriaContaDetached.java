package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaDetached {
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Marcia");
		conta.setNumero(12347);
		conta.setAgencia(74321);
		conta.setSaldo(100.0);
		
		//pego uma transacao para executar o escopo da tarefa
		em.getTransaction().begin();
		
		em.persist(conta);
		
		//gravo mas em caso de erro eu consigo dar um rollback.
		em.getTransaction().commit();
		
		em.close(); //depois de closed todas as contas que eram managed se tornam detached, ou seja nao da para fazer sincronizacao automatica
		
		
		EntityManager em2 = emf.createEntityManager();

		conta.setSaldo(800.00);
		
		System.out.println("Id da conta da marcia: "+ conta.getId());
		
		em2.getTransaction().begin();
		//funcao do merge e a conta se tornar managed novamente mudando o seu status atual (que seria detached)
		em2.merge(conta);
		
		em2.close();
		
		
		
	}


}
