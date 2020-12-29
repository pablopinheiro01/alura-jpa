package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamento {
	
	public static void main(String[] args) {
		
		Movimentacao mov = new Movimentacao();
		Conta conta = new Conta();
		conta.setAgencia(4565456);
		conta.setNumero(54564);
		conta.setTitular("Leonardo");
		conta.setSaldo(300.0);
		
		mov.setData(LocalDateTime.now());
		mov.setDescricao("Churras");
		mov.setValor(new BigDecimal(200.0));
		mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		mov.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(mov);
		em.getTransaction().commit();
		
		em.close();
		
		
	}

}
