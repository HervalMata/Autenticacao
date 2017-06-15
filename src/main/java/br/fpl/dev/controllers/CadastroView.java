package br.fpl.dev.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.fpl.dev.entities.Usuario;
import br.fpl.dev.service.UsuarioServiceIF;

@ManagedBean
public class CadastroView implements Serializable {
	
	@Inject
	private UsuarioServiceIF usu;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4196543258629769172L;
	
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	
	public String cadastrar(){
		
		Usuario usuCadastro = new Usuario();
		
		usuCadastro.setNome(nome);
		usuCadastro.setSobrenome(sobrenome);
		usuCadastro.setEmail(email);
		usuCadastro.setSenha(senha);
		
		
		if (usu.cadastrar(usuCadastro)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario cadastrado com sucesso!", ""));
			reset();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "E-mail Já cadastrado!", ""));
		}
		
		return null;
	}
	
	 /**
	  * Reseta os campos
	  */
	 public void reset(){
		 nome = new String();
		 sobrenome = new String();
		 email = new String();
		 senha = new String();
	 }
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
