document.addEventListener("DOMContentLoaded", () => {
    function pegarParametro(nome) {
        return new URLSearchParams(window.location.search).get(nome);
    }

    const idReceita = pegarParametro("receitaId");
    if (!idReceita) {
        document.getElementById("receitas-container").innerHTML = `
            <div class="alert alert-warning">ID da receita não informado.</div>`;
        return;
    }

    fetch(`/Projeto-Receitas/ReceitaJson?id=${idReceita}`)
        .then(res => res.json())
        .then(receita => {
            const container = document.getElementById("receitas-container");
            container.innerHTML = `
                <div class="card shadow-lg mx-auto" style="max-width: 40rem;">
                    <img src="${receita.fotoCaminho}" 
                         class="card-img-top img-fluid" 
                         alt="Foto da receita ${receita.nomeReceita}" 
                         style="height: 300px; object-fit: cover;">
                    <div class="card-body">
                        <h3 class="card-title fw-bold">${receita.nomeReceita}</h3>
                        <h5 class="card-subtitle text-muted mb-3">Autor: ${receita.autor}</h5>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item"><strong>Tempo de preparo:</strong> ${receita.tempo} min</li>
                            <li class="list-group-item"><strong>Categoria:</strong> ${receita.categoria}</li>
                            <li class="list-group-item"><strong>Avaliação média:</strong> ${receita.avaliacao || 'Sem avaliações'}</li>
                        </ul>
                    </div>
                </div>`;
            
            document.getElementById("input-receitaId").value = idReceita;

            return fetch(`/Projeto-Receitas/AvaliarReceitaServlet?receitaId=${idReceita}`);
        })
        .then(res => res.json())
        .then(avaliacoes => {
            const listaAvaliacoes = document.getElementById("avaliacoes-lista");
            listaAvaliacoes.innerHTML = "";

            if (!avaliacoes || avaliacoes.length === 0) {
                listaAvaliacoes.innerHTML = `<p class="text-muted">Nenhuma avaliação ainda.</p>`;
                return;
            }

            avaliacoes.forEach(avaliacao => {
                listaAvaliacoes.insertAdjacentHTML("beforeend", `
                    <div class="avaliacao-card mb-3 p-3 border rounded">
                        <p><strong>${avaliacao.autor || "Usuário anônimo"}</strong> avaliou com nota <strong>${avaliacao.nota || "-"}</strong></p>
                        <p>${avaliacao.comentario || ""}</p>
                    </div>`);
            });
        })
        .catch(() => {
            document.getElementById("receitas-container").innerHTML = `
                <div class="alert alert-danger">Erro ao carregar dados da receita.</div>`;
        });
});
