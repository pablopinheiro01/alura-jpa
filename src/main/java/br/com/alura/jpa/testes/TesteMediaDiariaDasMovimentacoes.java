package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteMediaDiariaDasMovimentacoes {
	
	/*
	 * insert into Movimentacao (data, valor, conta_id, descricao, tipoMovimentacao) values ('2017-01-12 18:01:07', 80.0, 2, 'Restaurante', 1);
insert into Movimentacao (data, valor, conta_id, descricao, tipoMovimentacao) values ('2017-01-12 19:31:12', 100.0, 2, 'Cinema', 1);
insert into Movimentacao (data, valor, conta_id, descricao, tipoMovimentacao) values ('2017-01-13 10:01:54', 40.0, 2, 'Café da manhã', 1);
insert into Movimentacao (data, valor, conta_id, descricao, tipoMovimentacao) values ('2017-01-14 15:20:13', 20.0, 2, 'Lanche', 1);
	 */
	
	public static void main(String[] args) {
		
	      EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	      EntityManager em = emf.createEntityManager();
	      
	      //essa query traz resultados de tipos diferentes
	      String jpql =  "select avg(m.valor) , day(m.data), month(m.data) from Movimentacao m group by day(m.data) , month(m.data), year(m.data)";
	      
	      Query query = em.createQuery(jpql);
	      
	      //podemos utilizar array de object para mais de um resultado porem essa nao e a melhor pratica
	      List<Object[]> mediaDasMovimentacoes = query.getResultList();
	      
	      for(Object[] resultado : mediaDasMovimentacoes) {
	    	  System.out.println("A media das movimentacoes do dia "+resultado[1] + "/" + resultado[2] + " é :  " + resultado[0]);
	      }
	      
	}

}
