package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	
	public static void main(String[] args) {
		
		//estado Transient existe na memoria mas ela nao tem ID nenhum, mas e um possivel condidato para ser manager no futuro.
		Conta conta = new Conta();
		
		conta.setTitular("Almiro");
		conta.setAgencia(9854);
		conta.setNumero(9875231);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		// Transient -> managed
		em.persist(conta);
		//uma conta managed que e removida do contexto da jpa, o banco de dados e sincronizado e executa um delete
		//managed - removed
		em.remove(conta);
		
		em.getTransaction().commit();
		
		
		
	}

}
