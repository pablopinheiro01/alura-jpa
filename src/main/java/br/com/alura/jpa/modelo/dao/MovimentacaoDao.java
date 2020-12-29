package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDao {
	
	private EntityManager em;
	
	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes(){
	      
	      //essa query traz resultados de tipos diferentes
	      // Double, integer e integer
	      //na projecao eu instancio o tipo que eu criei
//	      String jpql =  "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor) , day(m.data), month(m.data)) from Movimentacao m group by day(m.data) , month(m.data), year(m.data)";
	      
	      //Query query = em.createQuery(jpql);
	      //nao preciso mais usar a query generica, posso voltar a utilizar o TypedQuery<?>
//	      TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		//usado justamente com a anotacao @NamedQuery
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
	      
	      //podemos utilizar array de object para mais de um resultado porem essa nao e a melhor pratica
	      return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
	    
	    String jpql = "select sum(m.valor) from Movimentacao m ";
	    
	    TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
	    
	    return query.getSingleResult();
	}
	
	public Double getMediaDasMovimentacoes() {

		String jpqlAvg =  "select avg(m.valor) from Movimentacao m ";
	      
	      TypedQuery<Double> query2 = em.createQuery(jpqlAvg, Double.class);
	      
	      return query2.getSingleResult();
	}
	
	

}
