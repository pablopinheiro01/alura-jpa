package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	@Deprecated //indicado somente para fins de infraestrutura por causa do hibernate
	public Categoria() {
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome + " - " + this.id;
	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
