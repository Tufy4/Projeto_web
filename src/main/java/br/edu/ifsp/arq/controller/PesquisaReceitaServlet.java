package br.edu.ifsp.arq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;	
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifsp.arq.dao.ReceitasDAO;
import br.edu.ifsp.arq.model.Receita;

@WebServlet("/buscarReceitas")
public class PesquisaReceitaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String busca = request.getParameter("busca");
        List<Receita> todasReceitas = ReceitasDAO.getInstance().getListaReceitas();

       
        List<Receita> resultados = todasReceitas.stream()
                .filter(receita -> receita.getNomeReceita().toLowerCase().contains(busca.toLowerCase()))
                .collect(Collectors.toList());
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson(); 
        String json = gson.toJson(resultados);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();

        
    }
}
