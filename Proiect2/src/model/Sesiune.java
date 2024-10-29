package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sesiune {
    private String numeSesiune; //Yoga, Zumba, Pilates
    private Antrenor antrenor;
    private final Date data;
    private final List<Client> listaParticipanti;

    public Sesiune(String numeSesiune, Antrenor antrenor, Date data, String ora) {
        this.numeSesiune = numeSesiune;
        this.antrenor = antrenor;
        this.data = data;
        this.listaParticipanti = new ArrayList<>();
    }

    // Getter + Setter
    public String getNumeSesiune() {
        return numeSesiune;
    }

    public void setNumeSesiune(String numeSesiune) {
        this.numeSesiune = numeSesiune;
    }

    public Antrenor getAntrenor() {
        return antrenor;
    }

    public void setAntrenor(Antrenor antrenor) {
        this.antrenor = antrenor;
    }

    public List<Client> getListaParticipanti() {
        return listaParticipanti;
    }

    // Metode
    public void adaugaParticipant(Client client) {
        listaParticipanti.add(client);
        System.out.println(client.getNume() + " a fost adaugat la sesiunea " + numeSesiune + ".");
    }

    public void eliminaParticipant(Client client) {
        listaParticipanti.remove(client);
        System.out.println(client.getNume() + " a fost eliminat de la sesiunea " + numeSesiune + ".");
    }

    public void afiseazaDetaliiCurs() {
        System.out.println("Nume curs: " + numeSesiune);
        System.out.println("model.Antrenor: " + antrenor.getNume());
        System.out.println("Data: " + data);
        System.out.println("Participanți:");
        for (Client participant : listaParticipanti) {
            System.out.printf("%s %s%n", participant.getNume(), participant.getPrenume());
        }
    }
}
