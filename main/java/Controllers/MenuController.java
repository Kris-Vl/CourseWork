package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
    Controller controller = new Controller();

    private Stage stage;
    private Scene scene;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddCoffeeButton;

    @FXML
    private Button DeleteCoffeeButton;

    @FXML
    private Button DisplayListButton;

    @FXML
    private Button СoffeeVanCharactericric;

    @FXML
    private Button FindCoffeeButton;

    public MenuController() throws SQLException, IOException {
    }

    @FXML
    void DisplayListButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/sort.fxml");
    }

    @FXML
    void CoffeeVan(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene, "/org.coffee/coffeeVan.fxml");
    }

    @FXML
    void AddCoffee(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/add.fxml");
    }

    @FXML
    void DeleteCoffee(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/delete.fxml");
    }

    @FXML
    void FindCoffee(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/find.fxml");
    }

    @FXML
    void initialize() {
    }
}