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
	
	public Usuario autenticar(String email, String senha){
		
		List<Usuario> todosUsuarios = dao.buscarTodos();
		Usuario usuAutenticado = null;
		
		for (Usuario u : todosUsuarios){
			
			if (u.getEmail().equals(email)){
				
				if (u.getSenha().equals(senha)){
					
					return usuAutenticado = buscarPorEmail(email);
					
				}
			}
		}
		
		return usuAutenticado;
	}
	
	public Usuario buscarPorEmail(String email){
		
		List<Usuario> todosUsuarios = dao.buscarTodos();
		Usuario usuRetorno = null;
		
		for (Usuario u : todosUsuarios){
			
			if (u.getEmail().equals(email)){
				
				usuRetorno = new Usuario();
				
				usuRetorno.setId(u.getId());
				usuRetorno.setEmail(u.getEmail());
				usuRetorno.setSenha(u.getSenha());
				usuRetorno.setNome(u.getNome());
				usuRetorno.setSobrenome(u.getSobrenome());
				
				return usuRetorno;
			}
		}
		
		return usuRetorno;
	}

}
