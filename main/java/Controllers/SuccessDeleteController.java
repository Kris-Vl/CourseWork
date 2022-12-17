package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SuccessDeleteController {
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
    private Button DeleteButton;

    @FXML
    void BackToMenuButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/menu.fxml");
    }

    @FXML
    void Delete(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/delete.fxml");
    }
}

