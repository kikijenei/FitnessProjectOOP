import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AdaugaAntrenor {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:D:/Proiecte Java/Proiect2/fitness_gym.db";
        String sql = "INSERT INTO ANTRENOR(nume, prenume, specializare, parola) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Jenei");
            pstmt.setString(2, "Csabi");
            pstmt.setString(3, "fitness");//fitness, yoga, pilates, gym
            pstmt.setString(4, "csabi123");

            pstmt.executeUpdate();
            System.out.println("Antrenor adaugat");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
