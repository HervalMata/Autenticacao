package br.fpl.dev.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.fpl.dev.entities.Usuario;

@Named
@SessionScoped
public class SessaoBean implements Serializable {
	
	private Usuario usuario;
	
	/**
	 * Encerra a sessão do usuário
	 * @return página de login
	 */
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.jsf?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
