package br.fpl.dev.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.fpl.dev.entities.Usuario;
import br.fpl.dev.service.UsuarioServiceIF;

@Named
@RequestScoped
public class LoginBean implements Serializable{
	
	private String email;
	private String senha;
	
	@Inject
	private SessaoBean sessao;
	
	@Inject
	private UsuarioServiceIF usu;

	/**
	 * Verifica se o email e senha correspondem a algum usuário cadastrado no banco
	 * @return
	 */
	public String login() {

		Usuario usuAutenticado = usu.autenticar(email, senha);
		
		if (usuAutenticado != null) {
			// Caso exista o usuário, será redirecionado para página home.
			sessao.setUsuario(usuAutenticado);
			// Insere o usuário no SessaoBean
			return "/views/home.jsf?faces-redirect=true";
		
		} else {
			// Caso não, continuará na página de login, e receberá a mensagem de erro.
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dados incorretos!", "Verifique seu email e senha"));
			reset();
			return null;
		}
	}
	
	 /**
	  * limpa os campos
	  */
	 public void reset(){
		 email = null;
		 senha = null;
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
