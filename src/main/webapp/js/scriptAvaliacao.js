document.addEventListener("DOMContentLoaded", () => {
	const params = new URLSearchParams(window.location.search);

	const receitaId = params.get('receitaId');
	
document.getElementById("input-receitaId").value=receitaId;


});