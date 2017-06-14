package br.fpl.dev.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.fpl.dev.service.UsuarioService;

@ManagedBean
@SessionScoped
public class SessaoView implements Serializable {

	@Inject
	private UsuarioService usu;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5887667173989442369L;

	private String email;
	private String senha;

	public void login() {
		
		if(usu.autenticar(email, senha)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Logado!", ""));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dados incorretos!", ""));
		}

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
