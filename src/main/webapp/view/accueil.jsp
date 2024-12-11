<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Accueil</title>
</head>
<body>
	<% 
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	    response.setDateHeader("Expires", 0); // Proxies
	%>
	
    <div class="container" style="background-color: rgb(188, 196, 196); box-shadow: 1px 2px 10px 1px gray ; margin-top: 10px; padding-top: 50px; padding-bottom: 50px;">
        <div style="text-align: center;" class="container">
            <br>
            <%@ include file="deconnexion.jsp" %>
            <br>
            <br>
            <h1 id="bonjour" style="color: rgb(0, 55, 255); font-weight: bold;"></h1>
            <strong><h2 id="alpha" style="font-weight: bold;"></h2></strong>
            <h3 style="color: rgb(247, 12, 12);" id="bienvenu"></h3>
        </div>
        <br>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header" style="background-color: rgb(0, 55, 255);">
                        <strong style="color: white;"><h3>Informtions Utilisateur</h3></strong>
                    </div>
                    <div class="card-body">
                        <h4><strong>Nom:</strong> <%= request.getAttribute("nom") %></h4>
                        <h4><strong>Prénom:</strong> <%= request.getAttribute("prenom") %> </h4>
                        <h4><strong>Nom d'utilisateur:</strong> <%= request.getAttribute("identifiant") %></h4>
                    </div>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
    <script>
        function typeText(element, text, delayAfter, callback) {
            let index = 0;

            function type() {
                if (index < text.length) {
                    element.textContent += text[index];
                    index++;
                    setTimeout(type, 100); // Vitesse de saisie lettre par lettre
                } else {
                    element.style.opacity = 1; // Affiche complètement le texte
                    if (callback) {
                        setTimeout(callback, delayAfter);
                    }
                }
            }
            type();
        }

        document.addEventListener("DOMContentLoaded", () => {
            const bonjour = document.getElementById("bonjour");
            const alpha = document.getElementById("alpha");
            const bienvenu = document.getElementById("bienvenu");

            // Animation séquentielle
            typeText(bonjour, "BONJOUR", 2000, () => {
                typeText(alpha,"<%= request.getAttribute("prenom") %> <%= request.getAttribute("nom") %>", 2000, () => {
                    typeText(bienvenu, "Nous vous souhaitons bienvenu !", 1000);
                });
            });
        });
    </script>
</body>
</html>