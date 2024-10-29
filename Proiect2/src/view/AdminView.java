package view;
import model.SalaFitness;
import model.Client;
import model.Antrenor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;


public class AdminView {
    @FXML
    private ListView<String> clientiListView;
    @FXML
    private ListView<String> antrenoriListView;
    @FXML
    private Button adminBackBTN;
    Main mainController;
    private SalaFitness salaFitness;

    public AdminView(Main mainController) {
        this.mainController = mainController;
    }
    @FXML
    public void initialize() {
        salaFitness = new SalaFitness("Sala Fitness");
        salaFitness.incarcaClientidinBD();
        salaFitness.incarcaAntrenoridinBD();

        afiseazaClienti();
        afiseazaAntrenori();
    }

    private void afiseazaClienti() {
        clientiListView.getItems().clear();
        for (Client client : salaFitness.getClienti()) {
            clientiListView.getItems().add(client.getNume() + " " + client.getPrenume());
        }
    }

    private void afiseazaAntrenori() {
        antrenoriListView.getItems().clear();
        for (Antrenor antrenor : salaFitness.getListaAntrenori()) {
            antrenoriListView.getItems().add(antrenor.getNume() + " " + antrenor.getPrenume() + " - " + antrenor.getSpecializare());
        }
    }
    public void adminDisplay(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/admin-view.fxml"));
        loader.setController(this);
        Parent root = loader.load();

        setButtonActions(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Admin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setButtonActions(Stage primaryStage) {
        adminBackBTN.setOnAction(event -> {
            try {
                mainController.createMainLayout(primaryStage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


}


