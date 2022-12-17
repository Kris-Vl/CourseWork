package Controllers;

import CoffeeVan.Coffee.Coffee;
import DataBase.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FindByVolumeController {
    Controller controller = new Controller();
    private Stage stage;
    private Scene scene;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton1;

    @FXML
    private Button BackToMenuButton;

    @FXML
    private TextField maxValue;

    @FXML
    private TextField minValue;

    @FXML
    private Button FindButton;
    @FXML
    private TableView<Coffee> tableview;
    @FXML
    private  TableColumn<Coffee, String> title;
    @FXML
    private TableColumn<Coffee, String> Condition;
    @FXML
    private TableColumn<Coffee, String> Wrap;
    @FXML
    private TableColumn<Coffee, Number> Volume;
    @FXML
    private TableColumn<Coffee, Number> Cost;


    @FXML
    void Back(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/find.fxml");
    }

    @FXML
    void BackToMenuButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/menu.fxml");
    }

    @FXML
    void Find(ActionEvent event) throws SQLException {
        int min = Integer.parseInt(minValue.getText());
        int max = Integer.parseInt(maxValue.getText());
        ObservableList<Coffee> dataList = FXCollections.observableArrayList(DBHandler.FindbyVolume(min, max));
        tableview.setItems(dataList);
    }
    @FXML
    void initialize() throws SQLException, IOException {
        controller.setCells(title, Condition, Wrap, Volume, Cost);
        ObservableList<Coffee> dataList = FXCollections.observableArrayList(DBHandler.getCoffee());
        tableview.setItems(dataList);
    }

}
