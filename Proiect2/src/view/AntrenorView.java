package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class AntrenorView {
    @FXML
    private Button antrenorBackBTN;
    Main mainController;

    public AntrenorView(Main mainController) {
        this.mainController = mainController;
    }

    public void antrenorDisplay(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/antrenor-view.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        setButtonActions(primaryStage);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Antrenor");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void setButtonActions(Stage primaryStage) {
        antrenorBackBTN.setOnAction(event -> {
            try {
                mainController.createMainLayout(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

