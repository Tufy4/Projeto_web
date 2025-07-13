package br.edu.ifsp.arq.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifsp.arq.dao.AvaliacaoDAO;
import br.edu.ifsp.arq.dao.ReceitasDAO;
import br.edu.ifsp.arq.model.Avaliacao;
import br.edu.ifsp.arq.model.Receita;

@WebServlet("/AvaliacaoJsonServlet")
public class AvaliacaoJsonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	List<Avaliacao> Avaliacao = AvaliacaoDAO.getInstance().getListaAvaliacoes();


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson(); 
        String json = gson.toJson(Avaliacao);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}		
