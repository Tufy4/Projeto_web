document.addEventListener("DOMContentLoaded", () => {
    fetch("/Projeto-Receitas/SessionJsonServlet")
        .then(response => response.json())
        .then(usuario => {
            if (usuario != null) {
                let CadastrarUsuario = document.getElementById("CadastrarUsuario");
                let Login = document.getElementById("Login");
                	 CadastrarUsuario.style.display = "none";
					 Login.style.display = "none";
            }else{
				let SairSession = document.getElementById("SairSession");
				let cadastrarReceita = document.getElementById("CadastrarReceita");
				cadastrarReceita.style.display = "none";
				SairSession.style.display = "none";
				

				
			}
        });
});
