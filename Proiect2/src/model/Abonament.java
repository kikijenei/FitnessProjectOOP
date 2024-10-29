package model;

public class Abonament {
    private String tipAbonament; //basic, premium, elit
    private boolean cuAntrenor; //true-cu antrenor; false-fara antrenor p.
    private double pret;
    private int durata;

    //Constructorul
    public Abonament(String tipAbonament, boolean cuAntrenor, double pret, int durata) {
        this.tipAbonament = tipAbonament;
        this.cuAntrenor = cuAntrenor;
        this.pret = pret;
        this.durata = durata;
    }

    //Getter + Setter
    public String getTipAbonament() {
        return tipAbonament;
    }
    public void setTipAbonament(String tipAbonament) {
        this.tipAbonament = tipAbonament;
    }
    public boolean isCuAntrenor() {
        return cuAntrenor;
    }
    public void setCuAntrenor(boolean cuAntrenor) {
        this.cuAntrenor = cuAntrenor;
    }
    public double getPret() {
        return pret;
    }
    public void setPret(double pret) {
        if (pret > 0) {
            this.pret = pret;
        } else {
            throw new IllegalArgumentException("Pretul trebuie sa fie pozitiv!");
        }
    }
    public int getDurata() {
        return durata;
    }
    public void setDurata(int durata) {
        this.durata = durata;
    }

    //Metode
    public double calculeazaReducereDurata(){
        if(durata >= 6 && durata < 12){
            return pret * 0.10; //10% reducere la 6 luni minim
        }else if(durata >= 12 && durata < 24){
            return pret * 0.20;
        }else if(durata >= 24){
            return pret * 0.35;
        }
        return 0;
    }

    public double calculeazaReducereFidelitate(){
        return pret * 0.15;
    }

    public double calculeazaCostTotal(boolean clientFidel){
        double reducere = calculeazaReducereDurata();
        if(clientFidel){
            reducere += calculeazaReducereFidelitate();
        }
        double pretFinal = pret - reducere;
        if(pretFinal < 0){
            pretFinal = 0;
        }
        return pretFinal;
    }

}

