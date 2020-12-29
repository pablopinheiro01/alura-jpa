package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		//query orientada a objetos mais proximo do mundo OO
		String jpqlObjeto = "select  m from Movimentacao m where m.conta = :pConta";

		String jpql = "select  m from Movimentacao m where m.conta.id = 2";
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		EntityManager em = emf.createEntityManager();
		
		
		Query queryObject = em.createQuery(jpqlObjeto);
		
		queryObject.setParameter("pConta", conta);
		
		
		
		Query query = em.createQuery(jpql);
		
		List<Movimentacao> rs = query.getResultList();
		
		List<Movimentacao> rs2 = queryObject.getResultList();

		
		for(Movimentacao m : rs) {
			System.out.println("Descricao: "+m.getDescricao());
			System.out.println("Tipo: "+ m.getTipoMovimentacao());
		}
		
		for(Movimentacao m : rs2) {
			System.out.println("Descricao: "+m.getDescricao());
			System.out.println("Tipo: "+ m.getTipoMovimentacao());
		}
		
		
		
		
	}

}
