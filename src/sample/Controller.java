package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Button onButtonAdatokBetoltese;
    @FXML
    private ListView<DHaromszog> listViewDerekszoguHaromszog;
    @FXML
    private ListView<String> listViewHibak;

    @FXML
    public void onButtonAdatokBetoltese() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Szöveges állomány megnyitása");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Szöveges állományok (*txt)", "*.txt"));

        File fajl = fileChooser.showOpenDialog(null);
        fajlBeolvasas(fajl.toString());
    }
    public void fajlBeolvasas(String fajl){

        listViewHibak.getItems().clear();
        listViewDerekszoguHaromszog.getItems().clear();

        try {
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);

            int i = 1;
            String sor = br.readLine();
            while (sor != null) {
                try {
                    DHaromszog dh = new DHaromszog(sor, i++);
                    listViewDerekszoguHaromszog.getItems().add(dh);
                } catch (Exception e) {
                   listViewHibak.getItems().add(e.getMessage());
                } finally {
                    sor = br.readLine();
                }
            }
            fr.close();
            br.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
}
