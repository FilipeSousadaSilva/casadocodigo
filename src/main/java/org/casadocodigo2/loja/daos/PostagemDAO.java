package org.casadocodigo2.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo2.loja.models.Postagem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // torna a classe postagemdao, um bean(classe gerenciável) do spring (repository é usado em recursos persistentes)
@Transactional // Indica que a classe precisa de uma transação
public class PostagemDAO { 
	@PersistenceContext // o EntityManager trata-se de um recurso persistente, precisamos utilizar essa anotação 
	// para que o entity seja injetável 
	private EntityManager manager; // gerenciador de entidades responsável pela comunicação com o banco de dados
	public void gravar(Postagem postagem){ // Método que envia a postagem para o banco de dados
		manager.persist(postagem); 
	}
	public List<Postagem> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select p from Postagem p", Postagem.class).getResultList();
	}
}
