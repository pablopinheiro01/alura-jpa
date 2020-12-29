package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente clt = new Cliente();
		clt.setNome("Leonardo");
		clt.setEndereco("Rua da gambiarra 80");
		clt.setProfissao("Desenvolvedor de gambiarras");
		clt.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(clt);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
}
