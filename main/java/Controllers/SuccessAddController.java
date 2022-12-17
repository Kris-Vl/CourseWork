package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SuccessAddController {
    Controller controller = new Controller();

    private Stage stage;
    private Scene scene;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddButton;

    @FXML
    private Button BackToMenuButton;

    @FXML
    void Add(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/add.fxml");
    }

    @FXML
    void BackToMenuButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/menu.fxml");
    }
}
