package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJQPQLOrderBy {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		//query orientada a objetos mais proximo do mundo OO
		String sql = "select  m from Movimentacao m where m.conta = :pConta order by m.valor desc";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pConta", conta);
		
        List<Movimentacao> movimentacoes = query.getResultList();
		
		for(Movimentacao m : movimentacoes) {
			System.out.println("Descricao: "+m.getDescricao());
			System.out.println("Tipo: "+ m.getTipoMovimentacao());
		}
		
		
	}

}
