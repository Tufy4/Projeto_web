<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Algo deu errado - Página de Erro</title>
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        html, body {
            height: 100%;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }

        .error-page {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            height: 100vh;
            padding: 20px;
            text-align: left;
        }

        .error-page img {
            width: 100px;
            height: auto;
            margin-right: 20px;
            animation: bounce 1s infinite;
        }

        @keyframes bounce {
            0% { transform: scale(1); }
            50% { transform: scale(1.1); }
            100% { transform: scale(1); }
        }

        .message {
            max-width: 300px;
            border-left: 4px solid #ff4d4d;
            padding-left: 15px;
            margin-left: 15px;
        }

        .message h1 {
            color: #ff4d4d;
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .message p {
            font-size: 1rem;
            color: #333;
            margin-bottom: 15px;
        }

        .btn-primary {
            font-size: 0.9rem;
            padding: 8px 12px;
        }

        /* Responsividade para telas pequenas (até 430x320) */
        @media (max-width: 430px), (max-height: 320px) {
            .error-page {
                flex-direction: column;
                text-align: center;
                padding: 10px;
            }

            .error-page img {
                margin: 0 0 15px 0;
            }

            .message {
                margin: 0;
                border-left: none;
                border-top: 4px solid #ff4d4d;
                padding-top: 15px;
                padding-left: 0;
            }

            .message h1 {
                font-size: 1.3rem;
            }

            .message p {
                font-size: 0.95rem;
            }

            .btn-primary {
                width: 100%;
                font-size: 1rem;
            }
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="error-page">
            <img src="https://static.thenounproject.com/png/897391-200.png" alt="Ovo Quebrado" />
            <div class="message">
                <h1>Algo deu errado!</h1>
                <p>Encontramos um erro inesperado. Tente novamente ou volte à página inicial.</p>
                <a href="index.jsp" class="btn btn-primary">Página inicial</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>

</html>
