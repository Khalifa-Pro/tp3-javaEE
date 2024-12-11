package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utilisateur;

import java.io.IOException;
import java.sql.SQLException;

import dao.UtilisateurDao;

/**
 * Servlet implementation class SInscription
 */
public class SInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SInscription() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String nom = request.getParameter("nom");
		 String prenom = request.getParameter("prenom");
		 String identifiant = request.getParameter("identifiant");
		 String mot_de_passe = request.getParameter("mot_de_passe");
		 
		 Utilisateur utilisateur = new Utilisateur();
		 
		 utilisateur.setNom(nom);
		 utilisateur.setPrenom(prenom);
		 utilisateur.setIdentifiant(identifiant);
		 utilisateur.setMot_de_passe(mot_de_passe);
		 
		 UtilisateurDao dao = new UtilisateurDao();
		 
		 try {
			dao.inscrire(utilisateur);
			request.getRequestDispatcher("view/connexion.jsp").forward(request, response);
		} catch (SQLException e) {
			String existDeja = dao.existDeja;
			request.setAttribute("existDeja", existDeja);
			request.getRequestDispatcher("view/inscription.jsp").forward(request, response);
			e.printStackTrace();
		}
		  
		 
	}

}
