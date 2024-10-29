import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdaugaClient {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:D:/Proiecte Java/Proiect2/fitness_gym.db";
        String sql = "INSERT INTO CLIENT (nume, prenume, varsta, abonament, parola) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Jenei");
            pstmt.setString(2, "Csabi");
            pstmt.setInt(3, 16);
            pstmt.setString(4,"gym");
            pstmt.setString(5, "bigboss16");

            pstmt.executeUpdate();
            System.out.println("Client/a adaugat/a");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

