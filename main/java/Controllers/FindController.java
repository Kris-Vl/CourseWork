package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FindController {
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
    private Button FindByCostButton;

    @FXML
    private Button FindByVolumeButton;

    @FXML
    void BackToMenuButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/menu.fxml");
    }

    @FXML
    void FindByCost(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/findByCost.fxml");
    }

    @FXML
    void FindByVolume(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/findByVolume.fxml");
    }

    @FXML
    void initialize() {
        assert BackToMenuButton != null : "fx:id=\"BackToMenuButton\" was not injected: check your FXML file 'find.fxml'.";
        assert FindByCostButton != null : "fx:id=\"FindByCostButton\" was not injected: check your FXML file 'find.fxml'.";
        assert FindByVolumeButton != null : "fx:id=\"FindByVolumeButton\" was not injected: check your FXML file 'find.fxml'.";

    }

}
