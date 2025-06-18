<%@ include file="header.jsp" %>


<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Sobre o Sistema - Gerenciador de Receitas Culinárias</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <style>
 
  </style>
</head>



  
  <header class="py-5 mb-5 text-center">
    <div class="container">
      <h1 class="display-4 fw-bold mb-3">Gerenciador de Receitas Culinárias</h1>
      <p class="lead mb-4 fs-5">
        Compartilhe, organize e descubra receitas incríveis com facilidade e praticidade.
      </p>
      <a href="#funcionalidades" class="btn btn-primary btn-lg fw-semibold px-4">Conheça as Funcionalidades</a>
    </div>
  </header>

  <main class="container mb-5">


    <section id="sobre" class="mb-5">
      <div class="row align-items-center">
        <div class="col-md-6">
          <h2 class="fw-bold mb-3" style="color:#fd7e14;">Sobre o Sistema</h2>
          <p class="fs-5">
            Bem-vindo ao Gerenciador de Receitas Culinárias! Este sistema foi desenvolvido para facilitar o cadastro,
            visualização, edição e remoção de receitas culinárias por usuários registrados.
          </p>
          <p class="fs-5">
            Proporcionamos uma plataforma colaborativa onde os usuários compartilham receitas, aprendem novas
            preparações e organizam suas favoritas de forma prática e eficiente.
          </p>
        </div>
        <div class="col-md-6 text-center">
          <img src="images/l.png" alt="Imagem do sistema de receitas" class="img-fluid rounded shadow" />
        </div>
      </div>
    </section>

   
    <section id="funcionalidades" class="mb-5">
      <h2 class="fw-bold mb-4 text-center" style="color:#fd7e14;">Funcionalidades Principais</h2>
      <div class="row g-4 justify-content-center">

        <div class="col-12 col-md-6 col-lg-3">
          <div class="card h-100">
            <div class="card-body text-center">
              <div class="mb-3">
                <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="#fd7e14" class="bi bi-journal-plus"
                  viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
                    d="M8 5.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V10a.5.5 0 0 1-1 0V8.5H6a.5.5 0 0 1 0-1h1.5V6a.5.5 0 0 1 .5-.5z" />
                  <path
                    d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2zM2 2a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H2z" />
                </svg>
              </div>
              <h5 class="card-title fw-semibold mb-2">Cadastro de Receitas</h5>
              <p class="card-text small">Usuários podem adicionar novas receitas com informações completas.</p>
            </div>
          </div>
        </div>

        <div class="col-12 col-md-6 col-lg-3">
          <div class="card h-100">
            <div class="card-body text-center">
              <div class="mb-3">
                <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="#fd7e14"
                  class="bi bi-pencil-square" viewBox="0 0 16 16">
                  <path
                    d="M15.502 1.94a.5.5 0 0 1 0 .706l-1.292 1.292-2.122-2.121 1.292-1.292a.5.5 0 0 1 .707 0l1.415 1.415z" />
                  <path
                    d="M13.5 3.207L6 10.707V13h2.293l7.5-7.5-2.293-2.293zM1 13.5V16h2.5l8.96-8.96-2.5-2.5L1 13.5z" />
                </svg>
              </div>
              <h5 class="card-title fw-semibold mb-2">Edição e Remoção</h5>
              <p class="card-text small">Gerencie suas receitas, editando ou removendo sempre que precisar.</p>
            </div>
          </div>
        </div>

        <div class="col-12 col-md-6 col-lg-3">
          <div class="card h-100">
            <div class="card-body text-center">
              <div class="mb-3">
                <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="#fd7e14"
                  class="bi bi-search" viewBox="0 0 16 16">
                  <path
                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001l3.85 3.85a1 1 0 0 0 1.415-1.415l-3.85-3.85zm-5.242 1.146a5 5 0 1 1 0-10 5 5 0 0 1 0 10z" />
                </svg>
              </div>
              <h5 class="card-title fw-semibold mb-2">Busca Avançada</h5>
              <p class="card-text small">Encontre rapidamente receitas específicas usando a barra de busca eficiente.</p>
            </div>
          </div>
        </div>

        <div class="col-12 col-md-6 col-lg-3">
          <div class="card h-100">
            <div class="card-body text-center">
              <div class="mb-3">
                <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="#fd7e14"
                  class="bi bi-phone" viewBox="0 0 16 16">
                  <path
                    d="M11 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h6zm0 1H5v12h6V2z" />
                </svg>
              </div>
              <h5 class="card-title fw-semibold mb-2">Interface Responsiva</h5>
              <p class="card-text small">Compatível com dispositivos móveis e desktops, para acesso em qualquer lugar.</p>
            </div>
          </div>
        </div>
      </div>
    </section>

 
    <section id="desenvolvedores" class="mb-5">
      <h2 class="fw-bold mb-4 text-center" style="color:#fd7e14;">Desenvolvedores</h2>
      <div class="row g-4 justify-content-center">

        <div class="col-12 col-sm-6 col-md-4 col-lg-3">
          <div class="card h-100">
            <img src="images/bonitao.png" alt="João Silva" class="card-img-top" />
            <div class="card-body text-center">
              <h5 class="card-title fw-semibold">Tufy Elias</h5>
              <p class="card-text text-muted small">Lindo e charmoso</p>
            </div>
          </div>
        </div>

        <div class="col-12 col-sm-6 col-md-4 col-lg-3">
          <div class="card h-100">
            <img src="images/indio.png" alt="Maria Oliveira" class="card-img-top" />
            <div class="card-body text-center">
              <h5 class="card-title fw-semibold">Miguel(indião)</h5>
              <p class="card-text text-muted small">Made in Oca</p>
            </div>
          </div>
        </div>

        <div class="col-12 col-sm-6 col-md-4 col-lg-3">
          <div class="card h-100">
            <img src="images/g.png" alt="Carlos Santos" class="card-img-top" />
            <div class="card-body text-center">
              <h5 class="card-title fw-semibold">Gustavo</h5>
              <p class="card-text text-muted small">Pcd</p>
            </div>
          </div>
        </div>

      </div>
    </section>

  </main>








<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<%@ include file="footer.jsp" %>

</body>
</html>
