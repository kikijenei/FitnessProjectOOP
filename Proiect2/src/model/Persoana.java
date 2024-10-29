package model;
//mostenire client si antrenor + clasa abstracta
public abstract class Persoana {
    protected String nume;
    protected String prenume;
    protected int varsta;

    public Persoana(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getPrenume(){
        return prenume;
    }
    public void setPrenume(String prenume){
        this.prenume = prenume;
    }
    public int getVarsta(){
        return varsta;
    }
    public void setVarsta(int varsta){
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return nume + " " + prenume + ","+ varsta + "ani.";
    }
    public abstract String afiseazaDetalii();
}

