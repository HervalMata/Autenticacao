package br.fpl.dev.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.fpl.dev.dao.UsuarioDAO;
import br.fpl.dev.entities.Usuario;

@ManagedBean
public class UsuarioMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6120482453177449284L;

	@EJB
	private UsuarioDAO dao;

	private Usuario usuario;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}

	public void salvar() {

		System.out.println("USUARIO EMAIL - " + usuario.getEmail());

		dao.salvar(usuario);
	}

	// Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
