import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminaClient {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:D:/Proiecte Java/Proiect2/fitness_gym.db";
        String sql = "DELETE FROM Client WHERE nume = ? AND prenume = ?";

         //inlocuire exemplu
        String numeclient = "Csabi";
        String prenumeclient = "Csabi";


        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, numeclient);
            pstmt.setString(2, prenumeclient);

            int randuri = pstmt.executeUpdate();
            if (randuri > 0) {
                System.out.println("Client " + numeclient + " successfully eliminated.");
            } else {
                System.out.println("Client " + numeclient + " not eliminated.");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


