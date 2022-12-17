package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import CoffeeVan.Coffee.Coffee;
import CoffeeVan.CoffeeVan;
import DataBase.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoffeeVanController {
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
    private Text ProductCost;

    @FXML
    private Text TotalVolume;

    @FXML
    private Text UsedVolume;
    @FXML
    private TableView<Coffee> tableview;
    @FXML
    private TableColumn<Coffee, String> title;
    @FXML
    private TableColumn<Coffee, String> Condition;
    @FXML
    private TableColumn<Coffee,String> Wrap;
    @FXML
    private TableColumn<Coffee, Number> Volume;
    @FXML
    private TableColumn<Coffee, Number> Cost;

    @FXML
    void initialize() throws IOException, SQLException {
        String totalV = String.valueOf(CoffeeVan.getTotalVolume());
        TotalVolume.setText(totalV);
        UsedVolume.setText(DBHandler.getUsedVolume());
        ProductCost.setText(DBHandler.getCost());
        controller.setCells(title, Condition, Wrap, Volume, Cost);
        ObservableList<Coffee> dataList = FXCollections.observableArrayList(DBHandler.getCoffee());
        tableview.setItems(dataList);
    }

    @FXML
    void BackToMenuButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/menu.fxml");
    }

}
