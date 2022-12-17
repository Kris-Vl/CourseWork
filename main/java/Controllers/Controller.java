package Controllers;

import CoffeeVan.Coffee.Coffee;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class Controller {

    public void goTo(ActionEvent event, Stage stage, Scene scene, String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setCells(TableColumn<Coffee, String> title, TableColumn<Coffee, String> Condition, TableColumn<Coffee,
            String> Wrap, TableColumn<Coffee, Number> Volume, TableColumn<Coffee, Number> Cost){
        title.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        Condition.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCondition()));
        Wrap.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getWrap()));
        Volume.setCellValueFactory(cellData -> new ReadOnlyFloatWrapper(cellData.getValue().getVolume()));
        Cost.setCellValueFactory(cellData -> new ReadOnlyFloatWrapper((float) cellData.getValue().getCost()));
    }

}
