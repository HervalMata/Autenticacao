package br.fpl.dev.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class HomeBean implements Serializable{
	
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	
	@Inject
	private SessaoBean sessao;
	
	@PostConstruct
	public void init(){
		nome = sessao.getUsuario().getNome();
		sobrenome = sessao.getUsuario().getSobrenome();
		email = sessao.getUsuario().getEmail();
		senha = sessao.getUsuario().getSenha();
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
