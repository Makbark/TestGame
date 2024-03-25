package com.example.firstjavafxproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HelloApplication extends Application {
    @Override

    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            String css_login = this.getClass().getResource("HelloApplicationEffects.css").toExternalForm();
            String css_register = this.getClass().getResource("register-scene-Effects.css").toExternalForm();
            scene.getStylesheets().add(css_login);
            scene.getStylesheets().add(css_register);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        HelloController controller = new HelloController();

        FXMLLoader loader = new FXMLLoader();
        loader.setController(controller);
        launch();

    }
}