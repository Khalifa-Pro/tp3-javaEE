package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import connexion.BdConnexion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Utilisateur;

public class UtilisateurDao {
	
	public String existDeja;
		
	// Obtenir l'instance de la connexion
    BdConnexion databaseConnection = BdConnexion.getInstance();
    
    // Obtenir l'objet Connection
    private final Connection connection = databaseConnection.getConnection();
	
	// Requete sql
	private static final String REGISTER_USER_SQL = "INSERT INTO utilisateur(nom,prenom,identifiant,mot_de_passe) VALUES(?,?,?,?)";
        
	//private static final String USERS_LIST = "SELECT * FROM utilisateur";

    private static final String LOGIN_USER_SQL = "SELECT * FROM utilisateur WHERE identifiant=?";
    
    // Methode de hachage mot de passe
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error password hashed!", e);
        }
    }
    
    /**
     * Methode d'inscription
     * @param user
     * @throws SQLException
     */
    public void inscrire(Utilisateur user) throws SQLException {
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER_SQL)
        ) {
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getIdentifiant());
            preparedStatement.setString(4, hashPassword(user.getMot_de_passe()));
            
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Erreur : L'identifiant existe déjà.");
            this.existDeja = "L'identifiant existe déjà!";
            // Vous pouvez aussi lever une exception personnalisée ici si nécessaire
            throw new SQLException("L'identifiant existe déjà.");
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            throw e; // Renvoyer l'exception si elle n'est pas liée à une contrainte d'unicité
        } finally {
            // Fermer la connexion
            databaseConnection.closeConnection();
        }
    }
    
    /***
     * Methode de connexion
     * @param identifiant
     * @param motDePasse
     * @return
     */
    public Utilisateur connecter(String identifiant, String motDePasse) {
    	try (
    		   PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USER_SQL)) {

               preparedStatement.setString(1, identifiant);

               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   if (resultSet.next()) {
                   	String prenom = resultSet.getString("prenom");
                   	String nom = resultSet.getString("nom");
                    String identiFiant = resultSet.getString("identifiant");
                    String mot_de_passe = resultSet.getString("mot_de_passe");
                    
                    Utilisateur user = new Utilisateur();
                    
                    user.setPrenom(prenom);
                    user.setNom(nom);
                    user.setIdentifiant(identiFiant);
                    user.setMot_de_passe(mot_de_passe);
                    
                    if (user.getMot_de_passe().equals(hashPassword(motDePasse))) {
                       	return user; 
   					}else {
   						return null;
   					}
                   }
               }
           } catch (SQLException e) {
        	// Fermer la connexion
               databaseConnection.closeConnection();
           }
		return null;
 
    }
    
    
    /***
     * Logout with invalid session
     * @param request
     */
    public void logout(HttpServletRequest request) {
    	
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
            System.out.println("User logout");
        } else {
            System.out.println("Nothing session is found");
        }
    }

   
}
