
document.addEventListener("DOMContentLoaded", () => {
    fetch("/Projeto-Receitas/Login")
        .then(response => response.json())
        .then(mensagem => {
			if(mensagem!=null){
				const container = document.getElementById("containererro");
						console.log(mensagem);

				      
				               const card = `
				                   <h4 class="text-center "> ${mensagem} </h4>
								`;
				               container.insertAdjacentHTML("beforeend", card);
			}
			 
           
           
        })
        .catch(error => {
           console.log(error);
        });
});
