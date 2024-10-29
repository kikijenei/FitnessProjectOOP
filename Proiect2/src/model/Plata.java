package model;

import java.util.Date;

public class Plata {
    private double suma;
    private String metoda;//card sau cash
    private Date dataPlatii;

    public Plata(double suma, String metoda, Date dataPlatii) {
        this.suma = suma;
        this.metoda = metoda;
        this.dataPlatii = dataPlatii;
    }

    public Plata(double suma, String metoda){
        this.suma = suma;
        this.metoda = metoda;
        this.dataPlatii = new Date();
    }

    //Getter + setter
    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public String getMetoda() {
        return metoda;
    }

    public void setMetoda(String metoda) {
        this.metoda = metoda;
    }
    public Date getDataPlatii() {
        return dataPlatii;
    }

    public void setDataPlatii(Date dataPlatii) {
        this.dataPlatii = dataPlatii;
    }

    @Override
    public String toString() {
        return "Plata: " + suma + " RON prin " + metoda + " la " + dataPlatii;
    }
}

