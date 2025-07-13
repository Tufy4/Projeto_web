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
	
	
	@WebServlet("/ReceitaJson")
	public class ReceitaEspecificaServletJson extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private ReceitasDAO dao = ReceitasDAO.getInstance();	
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Receita ReceitaEscolhida = (Receita) getServletContext().getAttribute("Receita");
			System.out.println(ReceitaEscolhida.getFotoCaminho());
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        
	        Gson gson = new Gson(); 
	        String json = gson.toJson(ReceitaEscolhida);

	        PrintWriter out = response.getWriter();
	        out.print(json);
	        out.flush();
		}
	
		
	
	}
