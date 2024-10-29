package model;
import bd.ClientBD;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaFitness {
    private final String numeSala;
    private final ArrayList<Client> clienti;
    private final ArrayList<Antrenor> antrenori;
    private final ArrayList<Sesiune> cursuri ;

    public SalaFitness(String numeSala){
        this.numeSala = numeSala;
        this.clienti = new ArrayList<>();
        this.antrenori = new ArrayList<>();
        this.cursuri = new ArrayList<>();
    }

    //Getter + Setter
    public String getNumeSala() {
        return numeSala;
    }

    public ArrayList<Client> getClienti() {
        return clienti;
    }

    public ArrayList<Antrenor> getListaAntrenori() {
        return antrenori;
    }

    public ArrayList<Sesiune> getListaCursuri() {
        return cursuri;
    }

    //Metode
    public void adaugaClient(Client client) {
        clienti.add(client);
        System.out.println("Clientul/Clienta " + client.getNume() + " " + client.getPrenume() + " a fost adaugat/a.");
    }
    public void eliminaClient(Client client) {
        clienti.remove(client);
        System.out.println("Clientul/Clienta " + client.getNume() + " a fost eliminat/a.");
    }

    public void afiseazaClienti() {
        if(clienti.isEmpty()){
            System.out.println("Nu exista clienti ai salii...");
        }else {
            System.out.println("Lista de clienți ai salii de fitness:");
            for(Client client: clienti){
                System.out.println(client);
            }
        }
    }

    public void adaugaAntrenor(Antrenor antrenor) {
        antrenori.add(antrenor);
        System.out.println("Antrenorul/Antrenoarea " + antrenor.getNume() + " a fost adaugat/a.");
    }
    public void afiseazaAntrenori() {
        if(antrenori.isEmpty()){
            System.out.println("Nu exista momentan antrenori ai salii de fitness...");
        }else {
            System.out.println("Lista de antrenori ai salii de fitness:");
            for (Antrenor antrenor : antrenori) {
                System.out.println(antrenor.getNume());
            }
        }
    }

    public void trimiteReminder(Client client) {
        System.out.println("Reminder: Nu uitați sa veniti la antrenamente!");
    }

    public void checkInClient(Client client) {
        if (clienti.contains(client)) {
            System.out.println(client.getNume() + " " + client.getPrenume() + " a facut check-in la sala.");
            trimiteReminder(client);
        } else {
            System.out.println("Clientul nu exista in baza de date.");
        }
    }

    public void afiseazaInformatiiSala() {
        System.out.println("Numele salii: " + numeSala);
        System.out.println("Nr. clienți: " + clienti.size());
        System.out.println("Nr. antrenori: " + antrenori.size());
        System.out.println("Nr. cursuri: " + cursuri.size());
    }

    public void incarcaClientidinBD() {
        clienti.clear();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:D:/Proiecte Java/Proiect2/fitness_gym.db")){
            String sql = "SELECT * FROM CLIENT";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();

            while(result.next()){
                String nume = result.getString("nume");
                String prenume = result.getString("prenume");
                int varsta = result.getInt("varsta");
                String abonament = result.getString("abonament");
                String parola = result.getString("parola");

                Client client = new Client(nume, prenume, varsta, abonament, parola);
                clienti.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Client> getClientiDinBD() {
        ClientBD clientBD = new ClientBD();
        return clientBD.getAllClients();
    }

    public void incarcaAntrenoridinBD() {
        antrenori.clear();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:D:/Proiecte Java/Proiect2/fitness_gym.db")){
            String sql = "SELECT * FROM ANTRENOR";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();

            while(result.next()){
                String nume = result.getString("nume");
                String prenume = result.getString("prenume");
                String specializare = result.getString("specializare");
                String parola = result.getString("parola");

                Antrenor antrenor = new Antrenor(nume, prenume, specializare, parola);
                antrenori.add(antrenor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
