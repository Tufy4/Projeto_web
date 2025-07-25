package br.edu.ifsp.arq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.edu.ifsp.arq.dao.UsuarioDAO;
import br.edu.ifsp.arq.model.Usuario;
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;
	private int retorno;
	public String msg;

	public LoginServlet() {
		super();
		dao = UsuarioDAO.getInstance();	
	}

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
    
    	String mensagem =  (String) getServletContext().getAttribute("mensagem");
    	getServletContext().removeAttribute("mensagem");
    
    	System.out.println(mensagem);
    	Gson gson = new Gson(); 
    	String json = gson.toJson(mensagem);

    	PrintWriter out = response.getWriter();
    	out.print(json);
    	out.flush();
   
    

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		 if (usuario.isEmpty() || senha.isEmpty()) {
		        msg = "Tem que preencher o campo de usuario e senha";	
		        getServletContext().setAttribute("mensagem", msg);
		        getServletContext().getRequestDispatcher("/login.html").forward(request, response);
		    } else {
		        if (!dao.ExisteUsuario(usuario, senha)) {
		            msg = dao.getUsuarios().isEmpty() ? "Não há usuários cadastrados" : "Senha ou login incorretos";
		            getServletContext().setAttribute("mensagem", msg);
		            getServletContext().getRequestDispatcher("/login.html").forward(request, response);
		        } else {
		            Usuario user = dao.getUsuarioPorCredenciais(usuario, senha);

		            System.out.println("Logado com sucesso");

		            HttpSession session = request.getSession(); 
		            session.setAttribute("usuario", user); 
	

		            System.out.println("Sessão criada: " + session.getId());

		            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		        }
		    }
		}
	}