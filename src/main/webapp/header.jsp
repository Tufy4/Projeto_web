<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.edu.ifsp.arq.model.Receita" %>
<%@ page import="br.edu.ifsp.arq.dao.ReceitasDAO" %>
<%@ page import="br.edu.ifsp.arq.model.Usuario" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de Receitas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="icon" type="image/svg+xml" href="images/ovo2.svg">
 <link rel="stylesheet" href="css/style.css">
<link>
	
<style>
body {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
}
main {
    flex: 1;
}
.header-custom {
    background: linear-gradient(135deg, #ff9a00, #ff5e62);
    color: white;
}
.footer-custom {
    background-color: #333;
    color: white;
}
.footer-link {
    color: #ddd;
    text-decoration: none;
}
.footer-link:hover {
    color: #ff9a00;
}
.footer-heading {
    color: #ff9a00;
}
</style>
</head>
<body>


   
<header class="header-custom py-4 shadow ">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6 mb-3 mb-md-0 text-center text-md-start">
                <h1 class="fs-2 fw-bold">ReceitaFácil</h1>
                <p class="mb-0">Seu portal de receitas deliciosas</p>
            </div>
            <div class="col-md-6">
                <form action="buscarReceitas" method="get">
    				<input class="texto" type="text" name="busca" placeholder="Buscar receita..." required>
    				<input type="submit" value="Pesquisar">
				</form>

            </div>
        </div>
    </div>
</header>

<nav class="navbar navbar-expand-lg bg-dark">
    <div class="container">
        <button class="navbar-toggler bg-light mb-2 mt-2" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link text-white" href="index.jsp">Home</a>
                </li>
              
                <li class="nav-item">
                	
                    <a class="nav-link text-white" href="/Projeto-Receitas/ReadReceitaServlet">Receitas</a>
                </li>
                
               
                
                  <%
					Usuario usuario = (Usuario) session.getAttribute("usuario");
					    if (usuario != null) {
					        
					        
					    
					%>
                <li class="nav-item">
                    <a class="nav-link text-white" href="CadastrarReceitas.jsp">Cadastrar</a>
                </li>
                 <% } %>
                 
                 
                <li class="nav-item">
                    <a class="nav-link text-white" href="sobre.jsp">Sobre</a>
                </li>
            </ul>
            <ul class="navbar-nav">
            
             <%
					 usuario = (Usuario) session.getAttribute("usuario");
					    if (usuario == null) {
					        
					        
					    
					%>
                <li class="nav-item">
                    <a class="nav-link text-white" href="login.jsp">Login</a>
                </li>
                
                 <% } %>
                
                  <%
					usuario = (Usuario) session.getAttribute("usuario");
					    if (usuario != null) {
					        
					        
					    
					%>
                
                <li class="nav-item">
                    <a class="nav-link text-white" href="Logout">Sair</a>
                    
                </li>
                 <%} else{
                     %>
                     <% %>  <li class="nav-item">
                    <a class="nav-link text-white" href="CadastrarUsuario.jsp">Cadastre-se</a>
                    
                </li><% }%>
            </ul>
        </div>
    </div>
</nav>

