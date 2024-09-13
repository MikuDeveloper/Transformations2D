package ttn.developer.transformations2d;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Transformations2DApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Image appIcon = new Image(String.valueOf(Transformations2DApplication.class.getResource("icons/favicon.png")));
        FXMLLoader fxmlLoader = new FXMLLoader(Transformations2DApplication.class.getResource("transformations-2d-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("2D Transformations");
        stage.setResizable(false);
        stage.getIcons().add(appIcon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}