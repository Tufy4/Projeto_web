	package br.edu.ifsp.arq.controller;
	
	import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
	
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifsp.arq.dao.ReceitasDAO;
	import br.edu.ifsp.arq.model.Receita;
	
	
	@WebServlet("/Receita")
	public class ReceitaEspecificaServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private ReceitasDAO dao = ReceitasDAO.getInstance();	
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String Id = request.getParameter("id");
			Receita ReceitaEscolhida = dao.getReceita(Id);
			getServletContext().setAttribute("Receita", ReceitaEscolhida);
			
			
			 request.getRequestDispatcher("/ReceitaEspecifica.html").forward(request, response);

			
		}
	
		
	
	}
