package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;

public class Controller {

    @FXML
    public Button buttonAdatokBetoltese;

    @FXML
    public void onButtonAdatokBetoltese() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Szöveges állomány megnyitása");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Szöveges állományok (*txt)", "*.txt"));

        File fajl = fileChooser.showOpenDialog(null);
        System.out.println(fajl.toString());



    }
}
