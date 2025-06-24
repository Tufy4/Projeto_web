document.addEventListener("DOMContentLoaded", () => {
    fetch("/Projeto-Receitas/SessionJsonServlet")
        .then(response => response.json())
        .then(usuario => {
            if (usuario == null) {
				window.location.href = "index.html";

            }
        });
});
