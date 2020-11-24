package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConfirmationDialog {

    @FXML
    private Text confirmationText;

    @FXML
    private Button home;

    @FXML
    void goHome(ActionEvent event) {
        Stage appStage;
        Parent root;
        if(event.getSource()==home) {
            appStage = (Stage) home.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Scene scene = new Scene(root);
                appStage.setScene(scene);
                appStage.show();
            }catch(NullPointerException exception) {
                System.out.println("Oh. you have a null pointer somewhere...");
            }catch(Exception exception) {
                System.out.println("Oh snap, something happened");
                System.out.println(exception + " was thrown.");
            }
        }

    }

}
