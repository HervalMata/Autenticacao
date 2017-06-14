package br.fpl.dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		try {
			em.persist(tipo);
		} catch (Exception e){
			throw e;
		}
	}
	
	/**
	 * Método para atualizar objeto no banco
	 * @param tipo
	 */
	public void atualizar(T tipo){
		try {
			em.merge(tipo);
		} catch (Exception e){
			throw e;
		}
	}
	
	/**
	 * Método para deletar um objeto no banco
	 * @param tipo
	 */
	public void deletar(T tipo){
		try {
			em.remove(tipo);
		} catch (Exception e){
			throw e;
		}
	}
	
	/**
	 * Métodos para buscar todos os objetos no banco
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(){
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(tipo.getSimpleName());
		
		Query q = em.createQuery(sql.toString());
		
		return q.getResultList();
	}
	
}
