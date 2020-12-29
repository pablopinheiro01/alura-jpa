package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaSomaDasMovimentacoes {
	
	public static void main(String[] args) {
		
	      EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	      EntityManager em = emf.createEntityManager();
	      
	      String jpql = "select sum(m.valor) from Movimentacao m ";
	      
	      String jpqlAvg =  "select avg(m.valor) from Movimentacao m ";
	      
	      TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
	      
	      TypedQuery<Double> query2 = em.createQuery(jpqlAvg, Double.class);
	      
	      BigDecimal somaDasMovimentacoes = query.getSingleResult();
	      
	      Double mediaDasMovimentacoes = query2.getSingleResult();
	      
	      System.out.println("A soma das movimentacoes e: "+ somaDasMovimentacoes);
	      
	      System.out.println("A media das movimentacoes : "+ mediaDasMovimentacoes);
	      
	}
}
