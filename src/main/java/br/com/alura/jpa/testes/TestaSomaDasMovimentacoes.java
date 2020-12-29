package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {
	
	public static void main(String[] args) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	      EntityManager em = emf.createEntityManager();
		
	      System.out.println("A soma das movimentacoes e: "+ new MovimentacaoDao(em).getSomaDasMovimentacoes());
	      
	      System.out.println("A media das movimentacoes : "+ new MovimentacaoDao(em).getMediaDasMovimentacoes());
	      
	}
}
