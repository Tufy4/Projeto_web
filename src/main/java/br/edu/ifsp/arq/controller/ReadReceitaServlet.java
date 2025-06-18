package br.edu.ifsp.arq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.dao.ReceitasDAO;
import br.edu.ifsp.arq.model.Receita;

@WebServlet("/ReadReceitaServlet")
public class ReadReceitaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReceitasDAO dao=ReceitasDAO.getInstance();    
 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Receita> listaReceitas = dao.getListaReceitas();
        
        request.setAttribute("listaReceitas", listaReceitas);

        request.getRequestDispatcher("/lista-receitas.jsp").forward(request, response);
       
    }
}

