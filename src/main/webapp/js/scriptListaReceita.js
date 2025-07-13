document.addEventListener("DOMContentLoaded", async () => {
    const response = await fetch("/Projeto-Receitas/SessionJsonServlet");
    const usuario = await response.json();
	
	//TENTANDO REMOVER BOTAO DE ADICIONAR SEM SER ADM
    const btnAddReceita = document.getElementById("btn-add-receita");

    if (usuario && usuario.tipoUsuario === "administrador") {
        btnAddReceita.style.display = "inline-block";
    }
	//ATE AQ

    const logado = usuario != null;
    const tipoUsuario = usuario?.tipoUsuario || null;

    fetch("/Projeto-Receitas/ReceitasJsonServlet")
        .then(response => response.json())
        .then(receitas => {
			console.log(receitas);
            const container = document.getElementById("receitas-container");

            if (!receitas.length) {
                container.innerHTML = `
                    <div class="alert alert-warning" role="alert">
                        Não há receitas cadastradas.
                    </div>`;
                return;
            }

            receitas.forEach(receita => {
				console.log(receita);
				
                let botoes = "";
			
                if (logado && tipoUsuario === "administrador") {
                    botoes = `
                        <a href="/Projeto-Receitas/UpdateReceitaServlet?id=${receita.id}" class="btn btn-sm btn-dark">Editar</a>
                        <a href="/Projeto-Receitas/DeleteReceitaServlet?id=${receita.id}" class="btn btn-sm btn-danger">Deletar</a>`;
                }

                if (logado && tipoUsuario === "avaliador") {
					console.log("FOI");
                    botoes = `
                        <a href="/Projeto-Receitas/Avaliacao.html?receitaId=${receita.id}" class="btn btn-sm btn-warning">Avaliar</a>`;
                }

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
                                <strong>Tempo de preparo:</strong> ${receita.tempo}<br>
                                <strong>Categoria:</strong> ${receita.categoria}
                            </p>
                        </div>
                        <div class="card-footer d-flex justify-content-between">
                            ${botoes}
                        </div>
                    </div>
                </div>`;

                container.insertAdjacentHTML("beforeend", card);
            });
        })
        .catch(error => {
            console.error("Erro ao buscar receitas:", error);
            document.getElementById("receitas-container").innerHTML = `
                <div class="alert alert-danger" role="alert">
                    Erro ao carregar receitas.
                </div>`;
        });
});
