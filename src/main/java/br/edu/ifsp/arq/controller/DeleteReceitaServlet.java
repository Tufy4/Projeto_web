package br.edu.ifsp.arq.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.ifsp.arq.dao.ReceitasDAO;
import br.edu.ifsp.arq.model.Receita;

@WebServlet("/DeleteReceitaServlet")
public class DeleteReceitaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReceitasDAO dao = ReceitasDAO.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null && !idParam.isEmpty()) {
            // Chama o método do DAO para remover a receita pelo ID
            dao.removerReceitaPorId(idParam);
        }

        // Redireciona para a página de leitura das receitas
        response.sendRedirect("ReadReceitaServlet");
    }
}
