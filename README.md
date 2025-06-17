# 🍽️ CRUD - Sistema de Gerenciamento de Receitas Culinárias

**Autores:** Tufy Elias, Miguel Henrique, Gustavo Berzim  
**Descrição:** Sistema web completo para cadastro, visualização, edição, exclusão e avaliação de receitas culinárias, com controle de acesso por perfis de usuário.

---

## 📋 Funcionalidades

### 👤 Controle de Usuários
- Cadastro e login de usuários.
- Dois tipos de perfis:
  - **Usuário Padrão:** pode adicionar, editar, remover e visualizar receitas.
  - **Usuário Avaliador:** pode visualizar receitas, comentar e avaliar, mas **não pode** criar, editar ou excluir receitas.

### 🍲 Gerenciamento de Receitas
- Adicionar novas receitas.
- Visualizar lista e detalhes de receitas.
- Editar e excluir receitas cadastradas.
- Categorias disponíveis: **Entrada**, **Prato Principal**, **Sobremesa**, etc.
- Campos das receitas:
  - Nome da receita
  - Autor
  - Tempo de preparo
  - Ingredientes
  - Modo de preparo
  - Categoria
  - Rendimento
  - Avaliação dos usuários

### 💬 Comentários e Avaliações
- Usuários autenticados (inclusive avaliadores) podem comentar e avaliar receitas.
- Os comentários são exibidos na página de detalhes da receita.

### 🏠 Página Inicial
- Exibe:
  - Receitas em destaque
  - Novidades
  - Receitas mais populares

### 🔍 Navegação
Menu disponível em todas as páginas com as opções:
- **Home:** Página inicial com destaques.
- **Sobre o Sistema:** Descrição e informações sobre o projeto.
- **Categoria:** Filtro de receitas por categoria.
- **Login:** Autenticação de usuários.

### 🔐 Controle de Acesso
- Apenas usuários autenticados podem criar, editar ou excluir receitas.
- Acesso não autorizado redireciona para página de erro com mensagem explicativa.

---

## 🛠️ Tecnologias Utilizadas

- **Java EE (Servlets)**
- **HTML5, CSS3**
- **JavaScript**
- **Gson (para JSON)**
- **Apache Tomcat**

---

