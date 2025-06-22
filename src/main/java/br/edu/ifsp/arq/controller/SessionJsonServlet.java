package br.edu.ifsp.arq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.edu.ifsp.arq.dao.ReceitasDAO;
import br.edu.ifsp.arq.model.Receita;
import br.edu.ifsp.arq.model.Usuario;

/**
 * Servlet implementation class SessionJsonServlet
 */
@WebServlet("/SessionJsonServlet")
public class SessionJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);

	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        
	        Usuario usuario = null;
	        if (session != null) {
	            usuario = (Usuario) session.getAttribute("usuario"); // pega o usuário salvo na sessão
	        }
	        
	        Gson gson = new Gson(); 
	        String json = gson.toJson(usuario);

	        PrintWriter out = response.getWriter();
	        out.print(json);
	        out.flush();
	    
	}


}
