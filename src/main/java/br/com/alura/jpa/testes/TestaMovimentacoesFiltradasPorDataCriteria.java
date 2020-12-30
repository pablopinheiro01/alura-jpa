package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaMovimentacoesFiltradasPorDataCriteria {
	
	public static void main(String[] args) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	      EntityManager em = emf.createEntityManager();
	      
	      MovimentacaoDao dao = new MovimentacaoDao(em);
	      
//	     List<Movimentacao> movimentacoesFiltradasPorData =  dao.getMovimentacaoFiltradaPorData(null, null, 2017);
	     
	     List<Movimentacao> movimentacoesFiltradasPorData =  dao.getMovimentacaoFiltradaPorData(12, null, 2017);
	      
	     for(Movimentacao mov : movimentacoesFiltradasPorData) {
	    	 
	    	 System.out.println(" desc -> " + mov.getDescricao());
	    	 System.out.println("val -> "+ mov.getValor());
	    	 System.out.println("-----------------------");
	    	 
	     }
	      
		
	}
}
