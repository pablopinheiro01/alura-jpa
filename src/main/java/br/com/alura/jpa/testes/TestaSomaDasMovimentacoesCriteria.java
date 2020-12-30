package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;

public class TestaSomaDasMovimentacoesCriteria {
	
	public static void main(String[] args) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	      EntityManager em = emf.createEntityManager();
		
	      //constroi as querys e partes da query
	      CriteriaBuilder builder = em.getCriteriaBuilder();
	      CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
	      
	      //select m from Movimentacao
	      //aqui retorna a raiz da nossa query, se baseando nessa primeira parte
	      Root<Movimentacao> root = query.from(Movimentacao.class);
	      
	      //retorna uma expressao, a execucao da sum(m.valor)
	      Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
	      
	      query.select(sum);
	      
	      TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
	      
	      System.out.println("A soma das movimentacoes é: " + typedQuery.getSingleResult());
	      
	}
}
