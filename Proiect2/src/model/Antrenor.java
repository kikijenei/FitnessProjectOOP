package model;

public class Antrenor extends Persoana {
    private String specializare; // fitness, yoga, pilates etc.
    private final String parola;

    public Antrenor(String nume, String prenume, String specializare, String parola) {
        super(nume, prenume);
        this.specializare = specializare;
        this.parola = parola;
    }

    // Getter + Setter
    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        if (specializare == null || specializare.trim().isEmpty()) {
            throw new IllegalArgumentException("Trebuie sa fie specializare..");
        }
        this.specializare = specializare;
    }

    public String getParola(){
        return parola;
    }

    public void setParola(String parola){
        if (parola == null || parola.trim().isEmpty()) {
            throw new IllegalArgumentException("Trebuie sa fie parola..");
        }
    }

    // Metode
    //pt.encapsulare
    public String afiseazaDetalii() {
        return "Antrenor: " + nume + " " + prenume + " specializat in " + specializare;
    }

    @Override
    public String toString() {
        return afiseazaDetalii();
    }
}
