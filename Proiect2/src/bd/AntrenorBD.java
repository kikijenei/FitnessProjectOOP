package bd;
import java.io.PipedInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Antrenor;


public class AntrenorBD {
    public List<Antrenor> getAllAntrenor() {
        List<Antrenor> antrenorList = new ArrayList<>();
        String sql = "SELECT * FROM ANTRENOR";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Antrenor antrenor = new Antrenor(
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("specializare"),
                        rs.getString("parola")
                );
                antrenorList.add(antrenor);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la obținerea listei de antrenori: " + e.getMessage());
        }
        return antrenorList;
    }
    private static final String URL = "D:/Proiecte Java/Proiect2/fitness_gym.db";

    public static void adaugaAntrenor(Antrenor antrenor) {
        String sql = "INSERT INTO ANTRENOR(nume, prenume, specializare, parola VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, antrenor.getNume());
            pstmt.setString(2, antrenor.getPrenume());
            pstmt.setString(3, antrenor.getSpecializare());
            pstmt.setString(4, antrenor.getParola());
            pstmt.executeUpdate();
            System.out.println("Antrenor adaugat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adaugarea antrenorului.: " + e.getMessage());
        }
    }

    public static List<Antrenor> antrenorList() {
        List<Antrenor> antrenorList = new ArrayList<>();
        String sql = "SELECT * FROM ANTRENOR";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Antrenor antrenor = new Antrenor(
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("specializare"),
                        rs.getString("parola")
                );
                antrenorList.add(antrenor);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la obținerea listei de antrenori: " + e.getMessage());
        }
        return antrenorList;
    }
}
