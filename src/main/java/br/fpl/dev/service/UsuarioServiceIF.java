package br.fpl.dev.service;

import br.fpl.dev.entities.Usuario;

public interface UsuarioServiceIF {
	
	public Usuario autenticar(String email, String senha);
	
	public Usuario buscarPorEmail(String email);
	
	public boolean cadastrar(Usuario usuario);
}
