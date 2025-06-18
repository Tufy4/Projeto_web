<%@ include file="header.jsp" %>
<div class="container mt-5">
    <h2 class="mb-4">Editar Receita</h2>
    
    <form action="UpdateReceitaServlet?id=${receitaSelecionada.id}" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${receitaSelecionada.id}" />

        <div class="mb-3">
            <label class="form-label">Nome:</label>
            <input type="text" class="form-control" name="nome" value="${receitaSelecionada.nomeReceita}" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Autor:</label>
            <input type="text" class="form-control" name="autor" value="${receitaSelecionada.autor}" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Tempo de Preparo:</label>
            <input type="text" class="form-control" name="tempo" value="${receitaSelecionada.tempo}" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Categoria:</label>
            <select class="form-select" name="categoria" required>
                <option value="sobremesa" ${receitaSelecionada.categoria == 'sobremesa' ? 'selected' : ''}>Sobremesa</option>
                <option value="pratoPrincipal" ${receitaSelecionada.categoria == 'pratoPrincipal' ? 'selected' : ''}>Prato Principal</option>
                <option value="entrada" ${receitaSelecionada.categoria == 'entrada' ? 'selected' : ''}>Entrada</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Ingredientes:</label>
            <textarea class="form-control" name="ingredientes" rows="4" required>${receitaSelecionada.ingredientes}</textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Modo de Preparo:</label>
            <textarea class="form-control" name="modo" rows="4" required>${receitaSelecionada.modoPreparo}</textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Foto da Receita:</label>
            <input type="file" class="form-control" name="foto" accept="image/*" />
        </div>

        <button type="submit" class="btn btn-primary">Atualizar Receita</button>
        <a href="ReadReceitaServlet" class="btn btn-secondary ms-2">Cancelar</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<%@ include file="footer.jsp" %>
