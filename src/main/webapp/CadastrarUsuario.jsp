<%@ include file="header.jsp" %>

 
<div class="container d-flex align-items-start justify-content-center" style="min-height: 60vh; margin-top: 30px;">
    <div class="minimal-container col-lg-6 w-100">
        <h2 class="minimal-title text-center">Cadastro de Usuário</h2>
        
        <%
            String msg = (String) request.getAttribute("mensagem");
            if (msg != null) {
        %> 
            <h4 class="text-center"><%= msg %></h4>
        <%
            }
        %>
        
        
        <form action="CreateUsuarioServlet" method="post">
            <div class="field-group">
                <label for="nome" class="form-label">Nome</label>
                <input type="text" class="form-control" id="nome" name="nome" required>
            </div>

            <div class="field-group">
                <label for="password" class="form-label">Senha</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>

            <div class="d-grid mt-4">
                <button type="submit" class="btn btn-success">Cadastrar</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>
