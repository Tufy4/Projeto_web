document.addEventListener("DOMContentLoaded", () => {
    // Captura o ID da URL
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get("id");

    if (!id) {
        document.getElementById("receitas-container").innerHTML = `
            <div class="alert alert-warning" role="alert">ID da receita não especificado.</div>`;
        return;
    }

    // Função para escapar HTML e evitar quebra por caracteres especiais
    function escapeHtml(text) {
        return text
            .replace(/&/g, "&amp;")
            .replace(/"/g, "&quot;")
            .replace(/</g, "&lt;")
            .replace(/>/g, "&gt;");
    }

    fetch(`/Projeto-Receitas/UpdateReceitaServletJson?id=${id}`)
        .then(response => {
            if (!response.ok) throw new Error("Erro ao buscar a receita.");
            return response.json();
        })
        .then(receitaSelecionada => {
            const container = document.getElementById("receitas-container");

            const card = `
            <div class="container mt-5">
                <h2 class="mb-4">Editar Receita</h2>
                
                <form action="UpdateReceitaServlet?id=${receitaSelecionada.id}" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${receitaSelecionada.id}" />

                    <div class="mb-3">
                        <label class="form-label">Nome:</label>
                        <input type="text" class="form-control" name="nome" value="${escapeHtml(receitaSelecionada.nomeReceita)}" required />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Autor:</label>
                        <input type="text" class="form-control" name="autor" value="${escapeHtml(receitaSelecionada.autor)}" required />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Tempo de Preparo:</label>
                        <input type="text" class="form-control" name="tempo" value="${escapeHtml(receitaSelecionada.tempo)}" required />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Categoria:</label>
                        <select class="form-select" name="categoria" required>
                            <option value="sobremesa" ${receitaSelecionada.categoria === 'sobremesa' ? 'selected' : ''}>Sobremesa</option>
                            <option value="pratoPrincipal" ${receitaSelecionada.categoria === 'pratoPrincipal' ? 'selected' : ''}>Prato Principal</option>
                            <option value="entrada" ${receitaSelecionada.categoria === 'entrada' ? 'selected' : ''}>Entrada</option>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Ingredientes:</label>
                        <textarea class="form-control" name="ingredientes" rows="4" required>${escapeHtml(receitaSelecionada.ingredientes)}</textarea>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Modo de Preparo:</label>
                        <textarea class="form-control" name="modo" rows="4" required>${escapeHtml(receitaSelecionada.modoPreparo)}</textarea>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Foto da Receita:</label>
                        <input type="file" class="form-control" name="foto" accept="image/*" />
                    </div>

                    <button type="submit" class="btn btn-primary">Atualizar Receita</button>
                    <a href="ReadReceitaServlet" class="btn btn-secondary ms-2">Cancelar</a>
                </form>
            </div>
            `;

            container.innerHTML = card;
        })
        .catch(error => {
            console.error("Erro ao buscar receita:", error);
            document.getElementById("receitas-container").innerHTML = `
                <div class="alert alert-danger" role="alert">Erro ao carregar dados da receita.</div>`;
        });
});

