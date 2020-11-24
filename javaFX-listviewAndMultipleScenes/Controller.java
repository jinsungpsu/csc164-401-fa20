package sample;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView<Human> list;
    //private ListView<String> list;
    //private ListView<Button> list;


    @FXML
    private Button btn;

    // protected ListProperty<String> observableList = new SimpleListProperty<>();
    protected ListProperty<Human> observableHumanList = new SimpleListProperty<>();
    // protected ListProperty<Button> observableButtonList = new SimpleListProperty<>();

    @FXML
    void btnHandler(ActionEvent event) {

/*    void btnHandler(ActionEvent event) throws IOException {
        System.out.println(event);
        Stage appStage;
        Parent root;
        if(event.getSource()==btn)
        {
            appStage=(Stage)btn.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("listItemClicked.fxml"));
            Scene scene=new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

 */


        System.out.println(event);

        Stage appStage;
        Parent root;
        if(event.getSource()==btn) {
            appStage = (Stage) btn.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("confirmationDialog.fxml"));
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

    @FXML
    void listclickHandler(MouseEvent event) {
        System.out.println(event);
        System.out.println("you clicked on: " + list.getSelectionModel().getSelectedItem());
        Human selectedHuman = list.getSelectionModel().getSelectedItem();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();

        System.out.println("You selected index: " + selectedIndex);

        selectedHuman.setName("Clicked!");

        System.out.println(selectedHuman);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("world");

        ArrayList<Human> humanList = new ArrayList<>();
        humanList.add(new Human("MaryKate", 30));
        humanList.add(new Human("MaryKate", 30));


        // observableList.set(FXCollections.observableList(stringList));
        observableHumanList.set(FXCollections.observableList(humanList));

        list.itemsProperty().bind(observableHumanList);
    }
}
