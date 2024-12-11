package servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class ConnexionFilter
 */
public class ConnexionFilter extends HttpFilter implements Filter {

    private static final long serialVersionUID = 1L;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Vérifie si l'utilisateur est connecté
        HttpSession session = httpRequest.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        // URI de la page de connexion
        String loginURI = httpRequest.getContextPath() + "/connexion";
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        
        // URI de la page d'inscription
        String registerURI = httpRequest.getContextPath() + "/inscription";
        boolean registerRequest = httpRequest.getRequestURI().equals(registerURI);

        // Autorise l'accès si l'utilisateur est connecté ou si c'est une demande pour la page de connexion
        if (loggedIn || loginRequest || registerRequest) {
            chain.doFilter(request, response); // Passe à la ressource suivante
        } else {
            // Redirige vers la page de connexion si l'utilisateur n'est pas connecté
            httpResponse.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        // Code pour nettoyer les ressources si nécessaire
    }
}
