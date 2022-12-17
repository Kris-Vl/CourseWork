package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SortController {
    Controller controller = new Controller();

    private Stage stage;
    private Scene scene;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackToMenuButton;

    @FXML
    private Button SortByCostButton;

    @FXML
    private Button SortByNameButton;

    @FXML
    private Button SortByVolumeButton;

    @FXML
    void BackToMenuButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/menu.fxml");
    }

    @FXML
    void SortByCostButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/sortByCost.fxml");
    }

    @FXML
    void SortByNameButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/sortByName.fxml");
    }

    @FXML
    void SortByVolumeButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/sortByVolume.fxml");
    }

    @FXML
    void initialize() {
        assert BackToMenuButton != null : "fx:id=\"BackToMenuButton\" was not injected: check your FXML file 'display.fxml'.";
        assert SortByCostButton != null : "fx:id=\"SortByCostButton\" was not injected: check your FXML file 'display.fxml'.";
        assert SortByNameButton != null : "fx:id=\"SortByNameButton\" was not injected: check your FXML file 'display.fxml'.";
        assert SortByVolumeButton != null : "fx:id=\"SortByVolumeButton\" was not injected: check your FXML file 'display.fxml'.";

    }

}
