<%@ include file="header.jsp" %>



    <!--NOVIDADES DA SEMANA-->
    <div class="container mt-5">
        <h2>NOVIDADES DA SEMANA</h2>

        <!-- Carrossel de Receitas em Destaque -->
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <!-- Novidade 1 -->
                <div class="carousel-item active">
                    <img src="images/plantBased.jpg" class="d-block w-100" alt="Novidade 1" data-bs-toggle="modal"
                        data-bs-target="#novidadeModal1">
                    <div class="carousel-caption d-block d-md-block text-start bg-dark bg-opacity-50 rounded p-3">
                        <h5 class="h5">Cozinha Plant-Based (Baseada em Plantas)</h5>
                    </div>
                </div>
                <!-- Novidade 2 -->
                <div class="carousel-item">
                    <img src="images/tecnologiaNaCozinha.jpg" class="d-block w-100" alt="Novidade 2"
                        data-bs-toggle="modal" data-bs-target="#novidadeModal2">
                    <div class="carousel-caption d-block d-md-block text-start bg-dark bg-opacity-50 rounded p-3">
                        <h5 class="h5">Tecnologia na Cozinha</h5>
                    </div>
                </div>
                <!-- Novidade 3 -->
                <div class="carousel-item">
                    <img src="images/cozinhaFuncional.jpg" class="d-block w-100" alt="Receita 3" data-bs-toggle="modal"
                        data-bs-target="#novidadeModal3">
                    <div class="carousel-caption d-block d-md-block text-start bg-dark bg-opacity-50 rounded p-3">
                        <h5 class="h5">Cozinha Funcional: Alimentação que Cuida do Corpo e da Mente</h5>
                    </div>
                </div>
            </div>

            <!-- BotÃµes de navegaÃ§Ã£o -->
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Anterior</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">PrÃ³ximo</span>
            </button>
        </div>

        <!-- Modais com o conteÃºdo completo das novidades -->
        <!-- Modal 1 -->
        <div class="modal fade" id="novidadeModal1" tabindex="-1" aria-labelledby="novidadeModal1Label"
            aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="novidadeModal1Label">Cozinha Plant-Based (Baseada em Plantas)</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        A cozinha plant-based estão em alta, com alternativas vegetais cada vez mais sofisticadas.
                        Descubra como
                        você pode transformar seus pratos do dia a dia com opções sustentáveis e saudáveis.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal 2 -->
        <div class="modal fade" id="novidadeModal2" tabindex="-1" aria-labelledby="novidadeModal2Label"
            aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="novidadeModal2Label">Tecnologia na Cozinha</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        A tecnologia na cozinha estão transformando a maneira como preparamos alimentos, desde utensilios
                        até
                        sistemas automatizados. Explore as novas ferramentas que estão facilitando a vida na cozinha.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal 3 -->
        <div class="modal fade" id="novidadeModal3" tabindex="-1" aria-labelledby="novidadeModal3Label"
            aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="novidadeModal3Label">Cozinha Funcional: Alimentação que Cuida do
                            Corpo e da Mente</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        A cozinha funcional está em alta em 2025, combinando sabor e benefí­cios a  saúde. Alimentos que
                        oferecem
                        propriedades que auxiliam na melhora da saúde mental e física.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Receitas Populares -->
    <div class="container mt-5">
        <h2 class="text-center mb-4">RECEITAS POPULARES</h2>
         <%
         ReceitasDAO dao = ReceitasDAO.getInstance();	
ArrayList<Receita> lista = dao.getListaReceitas();


    if (lista == null || lista.isEmpty()) {
%>
    <div class="alert alert-warning" role="alert">
        Não há receitas cadastradas.
    </div>
<%
    } else {
%>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
<%
        for (Receita receita : lista) {
%>		
	        <div class="col">
	            <div class="card h-100">
	            	<a href="Receita?id=<%=receita.getId() %>">
	                	<img src="<%= receita.getFotoPath() %>" class="card-img-top" alt="Foto da receita <%= receita.getNomeReceita() %>" style="max-height: 200px; object-fit: cover;">
	                </a>
	                <div class="card-body">
	                    <h5 class="card-title"><%= receita.getNomeReceita() %></h5>
	                    <h6 class="card-subtitle mb-2 text-muted">Autor: <%= receita.getAutor() %></h6>
	                    <p class="card-text">
	                        <strong>Tempo de preparo:</strong> <%= receita.getTempo() %><br>
	                        <strong>Categoria:</strong> <%= receita.getCategoria() %>
	                    </p>
	                </div>
	               
	            </div>
	        </div>
      
<%
        }
%>
    </div>
<%
    }
%>
    </div>

  

    
</div> 
   
  <%@ include file="footer.jsp" %>