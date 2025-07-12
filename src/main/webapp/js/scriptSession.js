document.addEventListener("DOMContentLoaded", () => {
    fetch("/Projeto-Receitas/SessionJsonServlet")
        .then(response => response.json())
        .then(data => {

            let CadastrarUsuario = document.getElementById("CadastrarUsuario");
            let Login = document.getElementById("Login");
            let SairSession = document.getElementById("SairSession");
            let cadastrarReceita = document.getElementById("CadastrarReceita");

            
            if(data != null){
                Login.style.display = 'none';
                CadastrarUsuario.style.display = 'none';
				if (data.tipoUsuario === "comum") {
				     cadastrarReceita.style.display = 'none';
				} else {
				     cadastrarReceita.style.display = 'block';
				}

                
            } else {
                SairSession.style.display = 'none';
                cadastrarReceita.style.display = 'none';
            }
        })
        .catch(error => {
            console.error("Erro ao verificar sessão:", error);
        });
});
