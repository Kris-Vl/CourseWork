import DataBase.DBHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class main extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("/org.coffee/main.fxml"));
        Scene scene = new Scene(root);
        Image image = new Image("E:\\CoffeeVan\\src\\main\\resources\\org.coffee\\img\\png-clipart-coffee-cup-kitchen-mug-wall-decal-coffee-s-kitchen-text.png");
        stage.getIcons().add(image);
        DBHandler handler = new DBHandler();
        stage.setScene(scene);
        stage.setTitle("Coffee Van");
        stage.setWidth(700);
        stage.setHeight(400);
        stage.show();
    }
}
