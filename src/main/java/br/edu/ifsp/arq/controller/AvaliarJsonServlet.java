package br.edu.ifsp.arq.controller;

import br.edu.ifsp.arq.dao.ReceitasDAO;
import br.edu.ifsp.arq.model.Receita;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AvaliarJson")
public class 	AvaliarJsonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ReceitasDAO dao = ReceitasDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idStr = request.getParameter("id");
        if (idStr == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"erro\":\"Parâmetro id é obrigatório\"}");
            return;
        }

        try {
            Receita receita = dao.getReceita(idStr);

            if (receita == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"erro\":\"Receita não encontrada\"}");
                return;
            }

            Gson gson = new Gson();
            String json = gson.toJson(receita);
            response.getWriter().write(json);

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"erro\":\"ID inválido\"}");
        }
    }
}
