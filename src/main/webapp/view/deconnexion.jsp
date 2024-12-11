
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Accueil</title>
</head>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
    }

    .btn-deconnexion {
        background-color: #ff4b5c;
        color: #fff;
        padding: 12px 24px;
        font-size: 16px;
        font-weight: bold;
        border: none;
        border-radius: 25px;
        cursor: pointer;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        transition: all 0.3s ease;
    }

    .btn-deconnexion:hover {
        background-color: #ff6c75;
        transform: scale(1.05);
        box-shadow: 0 6px 10px rgba(0, 0, 0, 0.3);
    }

    .btn-deconnexion:active {
        transform: scale(0.95);
        box-shadow: 0 3px 5px rgba(0, 0, 0, 0.2);
    }
</style>
<a href="${pageContext.request.contextPath}/deconnexion" style="text-decoration: none;">
    <button class="btn-deconnexion">Déconnexion</button>
</a>

