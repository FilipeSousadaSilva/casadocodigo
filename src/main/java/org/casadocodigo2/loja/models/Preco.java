package org.casadocodigo2.loja.models;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable // Permite a persistência da classe Preco desde que ela seja atributo da classe postagem
// Adicionando as anotações o hibernate vai criar uma tabela chamada Produto_precos para gerenciar a lista de preços. 

public class Preco {
	
	
	private BigDecimal valor;
	private TipoPreco tipo;
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoPreco getTipo() {
		return tipo;
	}
	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}
	
	
}
