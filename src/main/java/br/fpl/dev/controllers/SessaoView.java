package br.fpl.dev.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.fpl.dev.entities.Usuario;
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

	/**
	 * 
	 * @return Usuario Autenticado
	 */
	public Usuario getUsuario() {
		return (Usuario) SessionContext.getInstance().getUsuarioAutenticado();
	}
	
	/**
	 * Login
	 * @return página home
	 */
	public String login() {

		Usuario usuAutenticado = usu.autenticar(email, senha);

		if (usuAutenticado != null) {

			SessionContext.getInstance().setAttribute("usuAutenticado", usuAutenticado);

			return "/views/home.jsf?faces-redirect=true";

		} else {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dados incorretos!", ""));
			return null;
		}

	}
	
	/**
	 * Logout
	 * @return página  login
	 */
	 public String logout() {
		 
         SessionContext.getInstance().encerrarSessao();
         System.out.println("SAINDO!");
         return "/index.jsf?faces-redirect=true";
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
