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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 AvaliacaoDAO dao = AvaliacaoDAO.getInstance();
        HttpSession session = request.getSession(false);
        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuario") : null;

        if (usuario == null || !"avaliador".equals(usuario.getTipoUsuario())) {
            response.sendRedirect("index.html");
            return;
        }

        
        	
        	
            int receitaId = Integer.parseInt(request.getParameter("receitaId"));
            int nota = Integer.parseInt(request.getParameter("nota"));
            String comentario = request.getParameter("comentario");

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setId(dao.lastId());

            avaliacao.setNota(nota);
            avaliacao.setComentario(comentario);
            avaliacao.setNomeAvaliador(usuario.getUsuario());
            avaliacao.setReceitaId(receitaId);

           
            dao.adicionarAvaliacao(avaliacao);

            
            response.sendRedirect("Receita?id=" + receitaId);

        
    }
    
    
  

    
    
    
}
