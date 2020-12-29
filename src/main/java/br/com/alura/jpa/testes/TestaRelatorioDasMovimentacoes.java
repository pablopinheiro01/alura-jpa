package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioDasMovimentacoes {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//left join trouxe todas as movimentacoes independente se tem relacionamento com as movimentacoes
		//usamos o join fetch para resolver a montagem de varias querys, podemos melhorar a nossa performance com essa tag
		String jpql = "select c from Conta c left join fetch c.movimentacoes";
		
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		
		List<Conta> contas = query.getResultList();
		
		for(Conta conta : contas) {
			System.out.println("Titular: "+ conta.getTitular());
			System.out.println("Agencia: "+conta.getAgencia());
			System.out.println("Numero: "+ conta.getNumero());
			//so faz a impressao quando e feito uma nova pesquisa
			//por padrao e feito em lazy load, por questao de performance
			System.out.println("Movimentacoes: "+ conta.getMovimentacoes());
			System.out.println(" ");
		}
		
		
		
	}

}
