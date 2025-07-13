
document.addEventListener("DOMContentLoaded", () => {
    fetch("/Projeto-Receitas/ReceitaJson")
        .then(response => response.json())
        .then(receita => {
            const container = document.getElementById("receitas-container");
			console.log(receita);
            
                const card = `
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
				                <li class="list-group-item"><strong>Avaliação:</strong> ${receita.avaliacao}</li>
				            </ul>
				        </div>
				    </div>`;
                container.insertAdjacentHTML("beforeend", card);
            
        })
        .catch(error => {
            console.error("Erro ao buscar receitas:", error);
            document.getElementById("receitas-container").innerHTML = `
                <div class="alert alert-danger" role="alert">Erro ao carregar receitas.</div>`;
        });
});
