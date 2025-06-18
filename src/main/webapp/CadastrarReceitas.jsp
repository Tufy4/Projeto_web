<%@ include file="header.jsp" %>

<%
if (session.getAttribute("usuarioNome") == null) {
    response.sendRedirect("error.jsp");
}
%>

<div class="container minimal-container col-lg-6">
    <h2 class="minimal-title text-center">Nova Receita</h2>
    <form action="CreateReceitaServlet" method="post" enctype="multipart/form-data">
        <div class="field-group">
        
            <label for="nome" class="form-label">Nome da Receita</label>
            <input type="text" class="form-control" id="nome" name="nomeReceita" required>
        </div>

        <div class="field-group">
            <label for="autor" class="form-label">Autor</label>
            <input type="text" class="form-control" id="autor" name="autor" required>
        </div>

        <div class="field-group">
            <label for="tempo" class="form-label">Tempo de Preparo (minutos)</label>
            <input type="number" class="form-control" id="tempo" name="tempoPreparo" required>
        </div>

        <div class="row">
            <div class="col-md-6 field-group">
                <label for="categoria" class="form-label">Categoria</label>
                <select class="form-select" id="categoria" name="categoria" required>
                    <option value="" selected disabled>Selecione</option>
                    <option value="Sobremesa">Sobremesa</option>
                    <option value="Prato Principal">Prato Principal</option>
                    <option value="Entrada">Entrada</option>
                </select>
            </div>

            <div class="col-md-6 field-group">
                <label for="avaliacao" class="form-label">Avaliação</label>
                <select class="form-select" id="avaliacao" name="avaliacao" required>
                    <option value="" selected disabled>Selecione</option>
                    <option value="1">1 estrela</option>
                    <option value="2">2 estrelas</option>
                    <option value="3">3 estrelas</option>
                    <option value="4">4 estrelas</option>
                    <option value="5">5 estrelas</option>
                </select>
            </div>
        </div>

        <div class="field-group">
            <label for="ingredientes" class="form-label">Ingredientes</label>
            <textarea class="form-control" id="ingredientes" name="ingredientes" rows="3" required></textarea>
        </div>

        <div class="field-group">
            <label for="modo" class="form-label">Modo de Preparo</label>
            <textarea class="form-control" id="modo" name="modoPreparo" rows="4" required></textarea>
        </div>

        <div class="field-group">
            <label for="foto" class="form-label">Foto da Receita</label>
            <input type="file" class="form-control" id="foto" name="foto" accept="image/*" required>
        </div>

        <div class="d-grid mt-4">
            <button type="submit" class="btn btn-success">Salvar</button>
        </div>
    </form>
</div>
<%@ include file="footer.jsp" %>



