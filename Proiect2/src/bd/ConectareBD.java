package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectareBD {
    private static final String URL = "jdbc:sqlite:D:/Proiecte Java/Proiect2/fitness_gym.sql";
    private static Connection connection = null;

    public static Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL);
                System.out.println("Conectat la baza de date SQLite.");
            }
        } catch (SQLException e) {
            System.err.println("Eroare la conectarea bazei de date: " + e.getMessage());
        }
        return connection;
    }

    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexiunea la baza de date a fost inchisa.");
            } catch (SQLException e) {
                System.err.println("Eroare la inchiderea conexiunii: " + e.getMessage());
            }
        }
    }
}
