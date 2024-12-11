package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utilisateur;

import java.io.IOException;

import dao.UtilisateurDao;

/**
 * Servlet implementation class SConnexion
 */
public class SConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("view/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String error = null; // Initialisation à null pour éviter l'affichage par défaut

	    String identifiant = request.getParameter("identifiant");
	    String mot_de_passe = request.getParameter("mot_de_passe");

	    UtilisateurDao dao = new UtilisateurDao();
	    Utilisateur user = dao.connecter(identifiant, mot_de_passe);

	    if (user == null) {
	        // Définit un message d'erreur si l'utilisateur est introuvable
	        error = "Identifiant ou mot de passe incorrect.";
	        request.setAttribute("error", error);
	        request.getRequestDispatcher("view/connexion.jsp").forward(request, response);
	    } else {
	        // Stocker l'utilisateur dans la session
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	        request.setAttribute("prenom", user.getPrenom());
	        request.setAttribute("nom", user.getNom());
	        request.setAttribute("identifiant", user.getIdentifiant());
	        // Redirige vers la page d'accueil
	        request.getRequestDispatcher("view/accueil.jsp").forward(request, response);
	    }
	}



}
