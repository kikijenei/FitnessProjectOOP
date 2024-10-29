package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class ClientView {
    @FXML
    private Button clientBackBTN;
    Main mainController;

    public ClientView(Main mainController) {
        this.mainController = mainController;
    }

    public void clientDisplay(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/client-view.fxml"));
        loader.setController(this);
        Parent root = loader.load();

        setButtonActions(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
    public void setButtonActions(Stage primaryStage) {
        clientBackBTN.setOnAction(event -> {
            try {
               mainController.createMainLayout(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

