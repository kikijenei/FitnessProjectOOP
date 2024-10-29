package view;
import bd.LoginBD;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @FXML
    private Stage primaryStage;
    @FXML
    private Button client_btn;
    @FXML
    private Button antrenor_btn;
    @FXML
    private Button admin_btn;
    @FXML
    private Button out;
    @FXML
    private TextField textFieldNume;
    @FXML
    private PasswordField passwordField;
    @FXML
    AdminView adminView;
    AntrenorView antrenorView;
    ClientView clientView;

    private LoginBD loginBD;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        adminView = new AdminView(this);
        antrenorView = new AntrenorView(this);
        clientView = new ClientView(this);

        loginBD = new LoginBD();
        createMainLayout(primaryStage);

    }

    public void createMainLayout(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login-view.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Logare Sala Fitness");
        primaryStage.setScene(scene);
        primaryStage.show();

        setButtonActions();
    }

    public void setButtonActions() {
        client_btn.setOnAction(e -> handleClientLogin());
        antrenor_btn.setOnAction(e -> handleAntrenorLogin());
        admin_btn.setOnAction(e -> {
            handleAdminLogin();
        });
        out.setOnAction(e -> handleExit());
    }

    private void handleClientLogin() {
        String nume = textFieldNume.getText();
        String parola = passwordField.getText();
        System.out.println("Client logat: " + nume + " cu parola: " + parola);
        System.out.println("Bun venit, " + nume);
        if(loginBD.clientExists(nume, parola)) {
            try{
                clientView.clientDisplay(primaryStage);
            }
            catch(Exception e){
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Utilizator negasit");
            alert.setContentText("Nume sau parola incorecta. Incercati din nou.");
            alert.showAndWait();
        }
    }

    private void handleAntrenorLogin() {
        String nume = textFieldNume.getText();
        String parola = passwordField.getText();
        System.out.println("Antrenor logat: " + nume + " cu parola: " + parola);
        try{
            antrenorView.antrenorDisplay(primaryStage);
        }
        catch(Exception e){
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

    private void handleAdminLogin() {
        String nume = textFieldNume.getText();
        String parola = passwordField.getText();
        System.out.println("Admin logat: " + nume + " cu parola: " + parola);
        try{
            adminView.adminDisplay(primaryStage);
        }
        catch(Exception e){
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

    private void handleExit() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmare Iesire");
        alert.setHeaderText("Siguri doriti sa iesiti din login?");
        alert.setContentText("OK - confirmare iesire  CANCEL - anulare iesire");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                showGoodbyeMessage();
                System.exit(0);
            }
        });
    }
    private void showGoodbyeMessage() {
        Alert goodbyeAlert = new Alert(AlertType.INFORMATION);
        goodbyeAlert.setTitle("La revedere");
        goodbyeAlert.setHeaderText(null);
        goodbyeAlert.setContentText("O zi buna! La revedere!");
        goodbyeAlert.showAndWait();
    }
    public static void main(String[] args) {
        launch(args);
    }
}