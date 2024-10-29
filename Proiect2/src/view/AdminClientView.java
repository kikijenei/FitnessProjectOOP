package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class AdminClientView {
    @FXML
    private Button admin_clienti_showBTN;
    @FXML
    private Button admin_clienti_addBTN;
    @FXML
    private Button admin_clienti_removeBTN;
    @FXML
    private Button admin_clientiBackBTN;
    AdminView adminView;

    public AdminClientView(AdminView adminView){
        this.adminView = adminView;
    }

    public void adminClientDisplay(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_clienti_view.fxml"));
        loader.setController(this);
        Parent root = loader.load();

        setButtonActions(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Admin Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setButtonActions(Stage primaryStage) throws IOException {
        admin_clienti_showBTN.setOnAction(e -> {
        });

        admin_clienti_addBTN.setOnAction(e -> {
        });

        admin_clienti_removeBTN.setOnAction(e -> {
        });

        admin_clientiBackBTN.setOnAction(e -> {
            try {
                adminView.adminDisplay(primaryStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}

