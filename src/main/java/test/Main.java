package test;

import java.sql.Connection;
import java.sql.SQLException;

import connexion.BdConnexion;

public class Main {
    public static void main(String[] args) {
        // Obtenir l'instance de la connexion
        BdConnexion databaseConnection = BdConnexion.getInstance();

        // Obtenir l'objet Connection
        Connection connection = databaseConnection.getConnection();

        // Exemple d'utilisation de la connexion (requête SQL)
        try {
            String sql = "SELECT * FROM utilisateur";
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("Utilisateur : " + resultSet.getString("nom"));
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        } finally {
            // Fermer la connexion
            databaseConnection.closeConnection();
        }
    }
}
