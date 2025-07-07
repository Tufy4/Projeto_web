package br.edu.ifsp.arq.controller;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import br.edu.ifsp.arq.dao.ReceitasDAO;
import br.edu.ifsp.arq.model.Receita;

@MultipartConfig
@WebServlet("/UpdateReceitaServlet")
public class UpdateReceitaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReceitasDAO dao;

    public UpdateReceitaServlet() {
        super();
        dao = ReceitasDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Receita> listaReceitas = dao.getListaReceitas();

        Receita receitaSelecionada = null;
        for (Receita receita : listaReceitas) {
            if (receita.getId() == id) {
                receitaSelecionada = receita;
                break;
            }
        }

        if (receitaSelecionada != null) {
        	getServletContext().setAttribute("Receita", receitaSelecionada);
        	getServletContext().getRequestDispatcher("/UpdateLista.html").forward(request, response);
        } else {
            response.sendRedirect("ReadReceitaServlet"); // caso não encontre a receita
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Receita> listaReceitas = dao.getListaReceitas();
        Receita receitaSelecionada = null;

        for (Receita receita : listaReceitas) {
            if (receita.getId() == id) {
                receitaSelecionada = receita;
                break;
            }
        }

        if (receitaSelecionada != null) {
  
            String nomeReceita = getFormField(request, "nome");
            String autor = getFormField(request, "autor");
            String tempoPreparo = getFormField(request, "tempo");
            String categoria = getFormField(request, "categoria");
            String ingredientes = getFormField(request, "ingredientes");
            String modoPreparo = getFormField(request, "modo");

            if (nomeReceita != null && !nomeReceita.isEmpty()) receitaSelecionada.setNomeReceita(nomeReceita);
            if (autor != null && !autor.isEmpty()) receitaSelecionada.setAutor(autor);
            if (tempoPreparo != null && !tempoPreparo.isEmpty()) receitaSelecionada.setTempo(tempoPreparo);
            if (categoria != null && !categoria.isEmpty()) receitaSelecionada.setCategoria(categoria);
            if (ingredientes != null && !ingredientes.isEmpty()) receitaSelecionada.setIngredientes(ingredientes);
            if (modoPreparo != null && !modoPreparo.isEmpty()) receitaSelecionada.setModoPreparo(modoPreparo);

   
            Part fotoPart = request.getPart("foto");
            if (fotoPart != null && fotoPart.getSize() > 0) {
                String fileName = Path.of(fotoPart.getSubmittedFileName()).getFileName().toString();
                String uploadPath = getServletContext().getRealPath("") + "uploads";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdir();
                String filePath = uploadPath + File.separator + fileName;
                fotoPart.write(filePath);
                receitaSelecionada.setFotoPath("uploads/" + fileName);
            }


            if (dao.atualizarReceita(receitaSelecionada)) {
                getServletContext().setAttribute("lista", dao.getListaReceitas());
                response.sendRedirect("ReadReceitaServlet");
            } else {
                response.sendRedirect("ReadReceitaServlet"); 
            }
        } else {
            response.sendRedirect("ReadReceitaServlet"); 
        }
    }


    private String getFormField(HttpServletRequest request, String fieldName) throws IOException, ServletException {
        Part part = request.getPart(fieldName);
        if (part != null) {
            return new String(part.getInputStream().readAllBytes(), "UTF-8").trim();
        }
        return null;
    }
}
