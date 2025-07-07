package br.edu.ifsp.arq.controller;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

import br.edu.ifsp.arq.dao.ReceitasDAO;
import br.edu.ifsp.arq.model.Receita;

@MultipartConfig
@WebServlet("/UpdateReceitaServletJson")
public class UpdateReceitaServletJson extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReceitasDAO dao;

    public UpdateReceitaServletJson() {
        super();
        dao = ReceitasDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	Receita ReceitaEscolhida = (Receita) getServletContext().getAttribute("Receita");
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        Gson gson = new Gson(); 
        String json = gson.toJson(ReceitaEscolhida);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
