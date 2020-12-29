package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//query orientada a objetos mais proximo do mundo OO
		//join faz a juncao em tabelas de relacionamento
		String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

		Categoria cat= new Categoria();
		cat.setId(3L);
		
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pCategoria", cat);
		
        List<Movimentacao> movimentacoes = query.getResultList();
		
		for(Movimentacao m : movimentacoes) {
			System.out.println("Categorias: "+ m.getCategorias());
			System.out.println("Descricao: "+m.getDescricao());
			System.out.println("Tipo: "+ m.getTipoMovimentacao());
		}
		
	}

}
