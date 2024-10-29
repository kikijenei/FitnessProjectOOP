package bd;

import java.io.PipedInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Client;

public class ClientBD {

    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT * FROM CLIENT";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Client client = new Client(
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getInt("varsta"),
                        rs.getString("abonament"),
                        rs.getString("parola")
                );
                clientList.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la obținerea listei de clienți: " + e.getMessage());
        }
        return clientList;
    }
    private static final String URL = "D:/Proiecte Java/Proiect2/fitness_gym.db";

    public static void adaugaClient(Client client) {
        String sql = "INSERT INTO CLIENT(nume, prenume, varsta, abonament, parola VALUES(?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, client.getNume());
            pstmt.setString(2, client.getPrenume());
            pstmt.setInt(3, client.getVarsta());
            pstmt.setString(4, client.getAbonament());
            pstmt.setString(5, client.getParola());
            pstmt.executeUpdate();
            System.out.println("Client adaugat cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adaugarea clientului.: " + e.getMessage());
        }
    }

    public static List<Client> clientList() {
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT * FROM CLIENT";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Client client = new Client(
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getInt("varsta"),
                        rs.getString("abonament"),
                        rs.getString("parola")
                );
                clientList.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Eroare la obținerea listei de clienți: " + e.getMessage());
        }
        return clientList;
    }
}


