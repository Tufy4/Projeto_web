document.addEventListener("DOMContentLoaded", async () => {
    try {
        const response = await fetch("/Projeto-Receitas/AvaliacaoJsonServlet");
		const params = new URLSearchParams(window.location.search);
		const receitaId = params.get("id");
		
        const avaliacoes = await response.json();

        console.log("Avaliações recebidas:", avaliacoes);

        const container = document.getElementById("avaliacoes-lista");

        
        container.innerHTML = "";
        const row = document.createElement("div");
        row.className = "row row-cols-1 row-cols-md-2 g-4";

        if (!avaliacoes || !avaliacoes.length) {
            container.innerHTML = `
                <div class="alert alert-warning" role="alert">
                    Não há avaliações cadastradas.
                </div>`;
            return;
        }

        avaliacoes.forEach(avaliacao => {
            console.log("Inserindo avaliação:", avaliacao);
		if(receitaId == avaliacao.receitaId){
			const card = `
			                <div class="col">
			                    <div class="card h-100">
			                        <div class="card-body">
			                            <h6 class="card-subtitle mb-2 text-muted">Autor: ${avaliacao.nomeAvaliador}</h6>
			                            <p class="card-text">
			                                <strong>Comentário:</strong> ${avaliacao.comentario}<br>
			                                <strong>Nota:</strong> ${avaliacao.nota}
			                            </p>
			                        </div>
			                    </div>
			                </div>`;

			            row.insertAdjacentHTML("beforeend", card);
		}
            
        });

        container.appendChild(row);

    } catch (error) {
        console.error("Erro ao buscar avaliações:", error);
        document.getElementById("avaliacoes-lista").innerHTML = `
            <div class="alert alert-danger" role="alert">
                Erro ao carregar avaliações.
            </div>`;
    }
});
