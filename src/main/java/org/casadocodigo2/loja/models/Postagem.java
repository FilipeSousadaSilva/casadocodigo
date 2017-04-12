package org.casadocodigo2.loja.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Anotação que transforma classe modelo em uma entidade do banco de dados
public class Postagem {
	private String titulo, descricao; // o Spring faz o binding com os dados que serão recebidos pelo formulário. 
	private int paginas; //o binding do Spring vincula cada valor de acordo com o seu nome.
	
	@ElementCollection //Permite a persistência de listas
	private List <Preco> precos;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //Solicita que o banco cuide da geração valores de chaves primárias
	private int id; // Atributo Id do banco de dados
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	@Override
	public String toString() {
		return "Postagem [titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
	}
	public List<Preco> getPrecos() {
		return precos;
	}
	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
