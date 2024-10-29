package model;

public class Reducere {
    private String tipReducere;//abonament, nutritie, giveaway
    private double procentReducere;

    public Reducere(String tipReducere) {
        this.tipReducere = tipReducere;
        this.procentReducere = procentReducere;
    }

    //Getter + Setter
    public String getTipReducere() {
        return tipReducere;
    }
    public void setTipReducere(String tipReducere) {
        this.tipReducere = tipReducere;
    }
    public double getProcentReducere(){
        return procentReducere;
    }
    public void setProcentReducere(double procentReducere){
        this.procentReducere = procentReducere;
    }

    //Metoda
    public void afiseazaDetaliiReducere() {
        System.out.println("Reducere la: " + tipReducere + "de" + procentReducere);
    }
}


