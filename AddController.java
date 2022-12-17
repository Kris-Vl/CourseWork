package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import CoffeeVan.Coffee.Coffee;
import CoffeeVan.Coffee.CoffeeCondition;
import CoffeeVan.Coffee.CoffeeType;
import CoffeeVan.Coffee.CoffeeWrap;
import DataBase.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class AddController {
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
    private ChoiceBox<CoffeeType> CoffeeTypeChoice;
    @FXML
    private ChoiceBox<CoffeeCondition> CoffeeConditionChoice;
    @FXML
    private ChoiceBox<CoffeeWrap> CoffeeWrapChoice;

    @FXML
    private Button AddButton;
    private final CoffeeType[] coffeeType = CoffeeType.values();
    private final CoffeeCondition[] coffeeCondition = CoffeeCondition.values();
    private final CoffeeWrap[] coffeeWrap = CoffeeWrap.values();
    private CoffeeType Name;
    private CoffeeCondition Condition;
    private CoffeeWrap Wrap;
    public AddController() throws SQLException, IOException {
    }
    @FXML
    void initialize() {
        CoffeeTypeChoice.getItems().addAll(coffeeType);
        CoffeeTypeChoice.setOnAction(this::getCoffeeType);

        CoffeeConditionChoice.getItems().addAll(coffeeCondition);
        CoffeeConditionChoice.setOnAction(this::getCoffeeCondition);

        CoffeeWrapChoice.getItems().addAll(coffeeWrap);
        CoffeeWrapChoice.setOnAction(this::getCoffeeWrap);
    }

    @FXML
    void BackToMenuButton(ActionEvent event) throws IOException {
        controller.goTo(event, stage, scene,"/org.coffee/menu.fxml");
    }

    private void getCoffeeType(ActionEvent event){
        Name = CoffeeTypeChoice.getValue();
    }
    private void getCoffeeCondition(ActionEvent event){
        Condition = CoffeeConditionChoice.getValue();
    }
    private void getCoffeeWrap(ActionEvent event){
        Wrap = CoffeeWrapChoice.getValue();
    }
    @FXML
    void Add(ActionEvent event) throws SQLException, IOException {
        Coffee coffee = new Coffee(Name, Condition, Wrap);
        if (DBHandler.addCoffee(coffee))
            controller.goTo(event, stage, scene,"/org.coffee/successAdd.fxml");
        else controller.goTo(event, stage, scene,"/org.coffee/failedAdd.fxml");
    }
}
