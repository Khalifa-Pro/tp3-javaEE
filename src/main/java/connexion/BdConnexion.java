package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnexion {
    // Instance unique de la connexion
    private static BdConnexion instance;
    
    private Connection connection;

    // URL, utilisateur et mot de passe de la base de données
    private static final String URL = "jdbc:mysql://localhost:3306/bdutilisateur";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Constructeur privé pour empêcher l'instanciation directe
    private BdConnexion() {
        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Créer la connexion
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion à la base de données réussie !");
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote JDBC introuvable : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
    }

    // Méthode pour obtenir l'instance unique de la connexion
    public static BdConnexion getInstance() {
        if (instance == null) {
            synchronized(BdConnexion.class) {
                if (instance == null) { // Double-checked locking pour assurer la sécurité des threads
                    instance = new BdConnexion();
                }
            }
        }
        return instance;
    }

    // Méthode pour obtenir la connexion
    public Connection getConnection() {
        return connection;
    }

    // Méthode pour fermer la connexion
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}

