package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static int numclicks = 0;

    private static ArrayList<Student> roster;

    @FXML
    private TextField textField;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    void button1clicked(ActionEvent event) {
        System.out.println("Clicked!");
        numclicks++;

        System.out.println(event);

        textField.setText("You clicked " + numclicks + " times...");

        button1.setText("Changed the button text!");

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println(url + " " + resourceBundle);

        System.out.println("ahhhhh I'm being born...");

        numclicks = 0;

        button1.setText("Button 1");

        button2.setText("Button 2");

        textField.setText("Initializing program.....");
    }

}
