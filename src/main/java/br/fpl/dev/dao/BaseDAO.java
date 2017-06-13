package br.fpl.dev.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDAO<T> {
	
	@PersistenceContext(unitName="cadastroPU")
	private EntityManager em;
	
	public Class<T> tipo;
	
	public BaseDAO(){ // Constructor
		
	}
	
	public BaseDAO(Class<T> tipo){ // Full Constructor
		this.tipo = tipo;
	}
	
	/**
	 * Método para salvar objeto no banco
	 * @param tipo
	 */
	public void salvar(T tipo){
		em.persist(tipo);
	}
	
	/**
	 * Método para atualizar objeto no banco
	 * @param tipo
	 */
	public void atualizar(T tipo){
		em.merge(tipo);
	}
	
}
