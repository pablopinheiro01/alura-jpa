package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

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
	      
	   List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao(em).getMediaDiariaDasMovimentacoes();
	      
	      for(MediaComData resultado : mediaDasMovimentacoes) {
	    	  System.out.println("A media das movimentacoes do dia "+resultado.getDia() + "/" + resultado.getMes() + " é :  " + resultado.getValor());
	      }
	      
	}

}
