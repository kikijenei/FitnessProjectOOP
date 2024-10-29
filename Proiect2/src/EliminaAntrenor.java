import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminaAntrenor {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:D:/Proiecte Java/Proiect2/fitness_gym.db";
        String sql = "DELETE FROM ANTRENOR WHERE nume = ? AND prenume = ?";

        String numeantrenor = "";
        String prenumeantrenor = "";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, numeantrenor);
            pstmt.setString(2, prenumeantrenor);

            int randuri = pstmt.executeUpdate();
            if (randuri > 0) {
                System.out.println("Trainer " + numeantrenor + " successfully eliminated.");
            } else {
                System.out.println("Trainer " + numeantrenor + " not eliminated.");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
