package br.edu.ifsp.arq.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

import br.edu.ifsp.arq.dao.AvaliacaoDAO;
import br.edu.ifsp.arq.model.Avaliacao;
import br.edu.ifsp.arq.model.Usuario;

@WebServlet("/AvaliarReceitaServlet")
public class AvaliarReceitaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuario") : null;

        if (usuario == null || !"avaliador".equals(usuario.getTipoUsuario())) {
            response.sendRedirect("index.html");
            return;
        }

        try {
            int receitaId = Integer.parseInt(request.getParameter("receitaId"));
            int nota = Integer.parseInt(request.getParameter("nota"));
            String comentario = request.getParameter("comentario");

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setReceitaId(receitaId);
            avaliacao.setNota(nota);
            avaliacao.setComentario(comentario);
            avaliacao.setNomeAvaliador(usuario.getUsuario());

            AvaliacaoDAO dao = new AvaliacaoDAO();
            dao.adicionarAvaliacao(avaliacao);

            
            response.sendRedirect("Receita?receitaId=" + receitaId);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("index.html");
        }
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String receitaId = request.getParameter("receitaId");

        if (receitaId == null) {
            response.sendRedirect("erro.html"); 
            return;
        }

        
        response.sendRedirect("Avaliacao.html?receitaId=" + receitaId);
    }

    
    
    
}
