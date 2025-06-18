<%@ include file="header.jsp" %>

<%
    Receita receita = (Receita) request.getAttribute("Receita");
%>

<div class="container my-5">
    <div class="card shadow-lg mx-auto" style="max-width: 40rem;">
        <img src="<%= receita.getFotoPath() %>" 
             class="card-img-top img-fluid" 
             alt="Foto da receita <%= receita.getNomeReceita() %>" 
             style="height: 300px; object-fit: cover;">

        <div class="card-body">
            <h3 class="card-title fw-bold"><%= receita.getNomeReceita() %></h3>
            <h5 class="card-subtitle text-muted mb-3">Autor: <%= receita.getAutor() %></h5>

            <ul class="list-group list-group-flush">
                <li class="list-group-item"><strong>Tempo de preparo:</strong> <%= receita.getTempo() %> min</li>
                <li class="list-group-item"><strong>Categoria:</strong> <%= receita.getCategoria() %></li>
                <li class="list-group-item"><strong>Avaliação:</strong> <%= receita.getAvaliacao() %></li>
            </ul>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
