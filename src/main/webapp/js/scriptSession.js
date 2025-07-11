document.addEventListener("DOMContentLoaded", () => {
    fetch("/Projeto-Receitas/SessionJsonServlet")
        .then(response => response.json())
        .then(data => {
            let CadastrarUsuario = document.getElementById("CadastrarUsuario");
            let Login = document.getElementById("Login");
            let SairSession = document.getElementById("SairSession");
            let cadastrarReceita = document.getElementById("CadastrarReceita");

            if (data && data.tipoUsuario) {
                CadastrarUsuario.style.display = "none";
                Login.style.display = "none";
                SairSession.style.display = "block";

                if (data.tipoUsuario === "admin") {
                    cadastrarReceita.style.display = "block";

                    const nav = document.querySelector(".navbar-nav.me-auto");
                    const li = document.createElement("li");
                    li.classList.add("nav-item");
                    li.innerHTML = `<a class="nav-link text-white" href="adminDashboard.html">Painel Admin</a>`;
                    nav.appendChild(li);
                } else {
                    cadastrarReceita.style.display = "none";
                }

            } else {
                CadastrarUsuario.style.display = "block";
                Login.style.display = "block";
                SairSession.style.display = "none";
                cadastrarReceita.style.display = "none";
            }
        })
        .catch(error => {
            console.error("Erro ao verificar sessão:", error);
        });
});
