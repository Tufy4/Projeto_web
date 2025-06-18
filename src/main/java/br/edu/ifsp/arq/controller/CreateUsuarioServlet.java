package br.edu.ifsp.arq.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifsp.arq.dao.ReceitasDAO;
import br.edu.ifsp.arq.dao.UsuarioDAO;
import br.edu.ifsp.arq.model.Receita;
import br.edu.ifsp.arq.model.Usuario;

@WebServlet("/CreateUsuarioServlet")

public class CreateUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int erro;
	public String msg;
	 private UsuarioDAO dao=UsuarioDAO.getInstance();  
   

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    String nomeUsuario = request.getParameter("nome");
		    String password = request.getParameter("password");

		    if (dao.ExisteUsuario(nomeUsuario,password)==false) {
		        Usuario newUser = new Usuario(nomeUsuario, password);
		        dao.adicionarUsuarios(newUser);
		        request.getRequestDispatcher("/login.jsp").forward(request, response);
		    } else {
		        msg = "Usuário já existe!";
		        request.setAttribute("mensagem", msg);
		        getServletContext().getRequestDispatcher("/CadastrarUsuario.jsp").forward(request, response);
		    }
		}

}
