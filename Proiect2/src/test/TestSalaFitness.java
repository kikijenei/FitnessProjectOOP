package test;
import model.SalaFitness;

public class TestSalaFitness {
    public static void main(String[] args) {

        SalaFitness sala = new SalaFitness("Sala de Fitnesss");
        sala.incarcaClientidinBD();
        sala.afiseazaClienti();
    }
}
