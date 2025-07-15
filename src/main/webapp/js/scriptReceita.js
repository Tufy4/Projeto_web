
document.addEventListener("DOMContentLoaded", () => {
    fetch("/Projeto-Receitas/ReceitasJsonServlet")
        .then(response => response.json())
        .then(receitas => {
            const container = document.getElementById("receitas-container");

            if (!receitas.length) {
                container.innerHTML = `<div class="alert alert-warning" role="alert">Não há receitas cadastradas.</div>`;
                return;
            }

            receitas.forEach(receita => {
				console.log(receita.fotoCaminho)
                const card = `
                    <div class="col">
                        <div class="card h-100">
                            <a href="Receita?id=${receita.id}">
                                <img src="${receita.fotoCaminho}" class="card-img-top" alt="Foto da receita ${receita.nomeReceita}" style="max-height: 200px; object-fit: cover;">
                            </a>
                            <div class="card-body">
                                <h5 class="card-title">${receita.nomeReceita}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">Autor: ${receita.autor}</h6>
                                <p class="card-text">
									<strong>Modo de preparo:</strong> ${receita.modoPreparo}<br>
                                    <strong>Tempo de preparo:</strong> ${receita.tempo}<br>
                                    <strong>Categoria:</strong> ${receita.categoria}
                                </p>
                            </div>
                        </div>
                    </div>`;
                container.insertAdjacentHTML("beforeend", card);
            });
        })
        .catch(error => {
            console.error("Erro ao buscar receitas:", error);
            document.getElementById("receitas-container").innerHTML = `
                <div class="alert alert-danger" role="alert">Erro ao carregar receitas.</div>`;
        });
});
