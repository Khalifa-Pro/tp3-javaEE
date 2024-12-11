<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Page de connexion</title>
	</head>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');

		/* Reseting */
		* {
		    margin: 0;
		    padding: 0;
		    box-sizing: border-box;
		    font-family: 'Poppins', sans-serif;
		}
		
		body {
		    background: #ecf0f3;
		}
		
		.wrapper {
		    max-width: 450px;
		    margin: auto;
		    margin-top: 20px;
		    padding: 40px 30px 30px 30px;
		    background-color: #ecf0f3;
		    border-radius: 15px;
		    box-shadow: 13px 13px 20px #cbced1, -13px -13px 20px #fff;
		}
		
		.logo {
		    width: 150px;
		    margin-left: 150px;
		}
		
		.logo img {
		    width: 90px;
		    height: 90px;
		}
		
		.wrapper .name {
		    font-weight: 600;
		    font-size: 1.4rem;
		    letter-spacing: 1.3px;
		    padding-left: 10px;
		    color: #555;
		}
		
		.wrapper .form-field input {
		    width: 100%;
		    display: block;
		    border: none;
		    outline: none;
		    background: none;
		    font-size: 1.2rem;
		    color: #666;
		    padding: 10px 15px 10px 10px;
		    /* border: 1px solid red; */
		}
		
		.wrapper .form-field select {
		    width: 100%;
		    display: block;
		    border: none;
		    outline: none;
		    background: none;
		    font-size: 1.2rem;
		    color: #666;
		    padding: 10px 15px 10px 10px;
		    /* border: 1px solid red; */
		}
		
		.wrapper .form-field {
		    padding-left: 10px;
		    margin-bottom: 20px;
		    border-radius: 20px;
		    box-shadow: inset 8px 8px 8px #cbced1, inset -8px -8px 8px #fff;
		}
		
		.wrapper .form-field .fas {
		    color: #555;
		}
		
		.wrapper .btn {
		    box-shadow: none;
		    width: 100%;
		    height: 40px;
		    background-color: #376EB5;
		    color: #fff;
		    border: none;
		    border-radius: 25px;
		    box-shadow: 3px 3px 3px #b1b1b1,
		        -3px -3px 3px #fff;
		    letter-spacing: 1.3px;
		}
		
		.wrapper .btn1 {
		    box-shadow: none;
		    width: 100%;
		    height: 40px;
		    background-color: #e70909;
		    color: #fff;
		    border: none;
		    border-radius: 25px;
		    box-shadow: 3px 3px 3px #b1b1b1,
		        -3px -3px 3px #fff;
		    letter-spacing: 1.3px;
		}
		
		.wrapper .btn:hover {
		    background-color: #555;
		}
		
		.wrapper a {
		    text-decoration: none;
		    font-size: 0.8rem;
		    color: #376EB5;
		}
		
		.wrapper a:hover {
		    color: #039BE5;
		}
		
		
		@media(max-width: 380px) {
		    .wrapper {
		        margin: 30px 20px;
		        padding: 40px 15px 15px 15px;
		    }
		}
		
	</style>
	<body>
	<br><br>
        <div class="wrapper">
            <br>
            <div class="text-center mt-4 name" style="text-align: center">
                Se connecter
            </div>
            <br>
            <form class="p-3 mt-3" method="POST" action="${pageContext.request.contextPath}/connexion">
				<div>
					<% 
					    String error = (String) request.getAttribute("error");
					    if (error != null) { 
					%>
					    <span style="color: red;"><%= error %></span>
					    <br><br>
					<% 
					    }
					%>
				</div>
                <!-- Login -->
                <div class="form-field d-flex align-items-center">
                    <span class="far fa-user"></span>
                    <input type="text" name="identifiant" id="identifiant" placeholder="Nom d'utilisateur">
                </div>

                <!-- Password -->
                <div class="form-field d-flex align-items-center">
                    <span class="fas fa-key"></span>
                    <input type="password" name="mot_de_passe" id="mot_de_passe" placeholder="Mot de passe">
                </div>
				<!-- Submit button -->
                <button class="btn mt-3" type="submit"><strong>Se connecter</strong></button>
            </form>
            <a href="${pageContext.request.contextPath}/inscription">Creer compte ?</a>
        </div>
    </body>
</html>