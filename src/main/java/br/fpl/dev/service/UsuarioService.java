package br.fpl.dev.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.fpl.dev.dao.UsuarioDAO;
import br.fpl.dev.entities.Usuario;

@Stateless
public class UsuarioService {
	
	@Inject
	private UsuarioDAO dao;
	
	public boolean autenticar(String email, String senha){
		
		List<Usuario> todosUsuarios = dao.buscarTodos();
		
		for (Usuario u : todosUsuarios){
			
			if (u.getEmail().equals(email)){
				
				if (u.getSenha().equals(senha)){
					return true;
				}
			}
		}
		
		return false;
	}
}
