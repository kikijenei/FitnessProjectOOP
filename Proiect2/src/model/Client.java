package model;

public class Client extends Persoana {
    private String abonament;
    private final String parola;

    public Client(String nume, String prenume, int varsta, String abonament, String parola) {
        super(nume, prenume, varsta);
        this.abonament = abonament;
        this.parola = parola;
    }

    //Getter + Setter
    public String getAbonament() {
        return abonament;
    }

    public void setAbonament(String abonament) {
        this.abonament = abonament;
    }

    public String getParola() {
        return parola;
    }

    //Metode
    @Override
    public String toString() {
        return "Client: " + nume + " " + prenume + ", " + varsta + " ani";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return varsta == client.varsta &&
                nume.equals(client.nume) &&
                prenume.equals(client.prenume);
    }
    @Override
    public String afiseazaDetalii() {
        System.out.println("Client: " + getNume() + " " + getPrenume() + ", " + getVarsta() + " ani, abonament: " + abonament);
        return null;
    }
}
