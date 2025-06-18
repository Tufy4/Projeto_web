<%@ include file="header.jsp" %>

<div class="container mt-5 d-flex align-items-start justify-content-center" style="min-height: 60vh; margin-top: 30px;">
    <div class="w-100">
        <%
        ArrayList<Receita> lista = (ArrayList<Receita>) request.getAttribute("listaReceitas");

        if (lista == null || lista.isEmpty()) {
        %>
            <div class="alert alert-warning" role="alert">
                Não há receitas cadastradas.
            </div>
        <%
        } else {
        %>
            <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <%
            for (Receita receita : lista) {
                if (receita != null) { // Verifica se o objeto receita não é null
        %>		
                <div class="col">
                    <div class="card h-100">
                        <a href="Receita?id=<%= receita.getId() %>">
                            <img src="<%= receita.getFotoPath() %>" class="card-img-top" alt="Foto da receita <%= receita.getNomeReceita() %>" style="max-height: 200px; object-fit: cover;">
                        </a>
                        <div class="card-body">
                            <h5 class="card-title"><%= receita.getNomeReceita() %></h5>
                            <h6 class="card-subtitle mb-2 text-muted">Autor: <%= receita.getAutor() %></h6>
                            <p class="card-text">
                                <strong>Tempo de preparo:</strong> <%= receita.getTempo() %><br>
                                <strong>Categoria:</strong> <%= receita.getCategoria() %>
                            </p>
                        </div>
                        <%
                         usuario = (Usuario) session.getAttribute("usuario");
                        if (usuario != null) {
                        %>
                            <div class="card-footer d-flex justify-content-between">
                                <a href="/Projeto-Receitas/UpdateReceitaServlet?id=<%= receita.getId() %>" class="btn btn-sm btn-dark">Editar</a>
                                <a href="/Projeto-Receitas/DeleteReceitaServlet?id=<%= receita.getId() %>" class="btn btn-sm btn-danger">Deletar</a>
                            </div>
                        <% 
                        }
                        %>
                    </div>
                </div>
        <%
                }
            }
        %>
            </div>
        <%
        }
        %>
        
        <%
         usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
        %>
            <div class="mt-4">
                <a href="/Projeto-Receitas/CadastrarReceitas.jsp" class="btn btn-success">Adicionar Nova Receita</a>
            </div>
        <% 
        }
        %>
        
    </div>
</div>

<%@ include file="footer.jsp" %>
