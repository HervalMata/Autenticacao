package br.fpl.dev.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.fpl.dev.entities.Usuario;
import br.fpl.dev.service.UsuarioServiceIF;

@Named
@ViewScoped
public class CadastroBean implements Serializable {
	
	@Inject
	private UsuarioServiceIF usu;
	
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	
	/**
	 * Cadastra o usuário no banco de dados
	 * @return
	 */
	public String cadastrar(){
		
		Usuario usuCadastro = new Usuario();
		
		// Dados
		usuCadastro.setNome(nome);
		usuCadastro.setSobrenome(sobrenome);
		usuCadastro.setEmail(email);
		usuCadastro.setSenha(senha);
		
		if (usu.cadastrar(usuCadastro)){
			// Caso o método cadastrar retorne true, exibe mensagem de informação
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario cadastrado com sucesso!", ""));
			reset();
			
		} else {
			// Caso retorne false, exibe mensagem de aviso
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "E-mail Já cadastrado!", ""));
		}
		
		return null;
	}
	
	 /**
	  * limpa os campos
	  */
	 public void reset(){
		 nome = null;
		 sobrenome = null;
		 email = null;
		 senha = null;
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
