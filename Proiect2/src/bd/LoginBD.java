package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginBD {
    private String URL = "jdbc:sqlite:D:/Proiecte Java/Proiect2/fitness_gym.db";
    private Connection connection;

    public LoginBD() {
        try {
            connection = DriverManager.getConnection(URL);
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
     public boolean clientExists(String nume, String parola) {
         String cerinta = "SELECT * FROM CLIENT WHERE nume = '" + nume + "' AND parola = '" + parola + "'";
         try(Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(cerinta)) {
             return rs.next();
         }catch (SQLException ex) {
             ex.printStackTrace();
             return false;
         }
     }
}


