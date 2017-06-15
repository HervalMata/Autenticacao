package br.fpl.dev.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.fpl.dev.entities.Usuario;

@WebFilter(urlPatterns="/views/*")
public class ControleAcessoFilter implements Filter{
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Usuario usuAutenticado = null;
		HttpSession sessao = ((HttpServletRequest) request).getSession(false);
		
		if (sessao != null) {
			usuAutenticado = (Usuario) sessao.getAttribute("usuAutenticado");
		}
		
		if (usuAutenticado == null){
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("/cadastro/index.jsf");
		} 
		
		chain.doFilter(request, response);
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
			
	}
	
	

}
