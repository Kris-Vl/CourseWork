package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
import javafx.stage.Stage;

public class SortByVolumeController {
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
    private Button BackButton1;
    @FXML
    private TableView<Coffee> tableview;
    @FXML
    private  TableColumn<Coffee, String> title;
    @FXML
    private TableColumn<Coffee, String> Condition;
    @FXML
    private TableColumn<Coffee,String> Wrap;
    @FXML
    private TableColumn<Coffee, Number> Volume;
    @FXML
    private TableColumn<Coffee, Number> Cost;

    @FXML
    void BackToMenuButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/menu.fxml");
    }

    @FXML
    void initialize() throws SQLException {
        controller.setCells(title, Condition, Wrap, Volume, Cost);
        ObservableList<Coffee> dataList = FXCollections.observableArrayList(DBHandler.SortbyVolume());
        tableview.setItems(dataList);

    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/sort.fxml");
    }

}
