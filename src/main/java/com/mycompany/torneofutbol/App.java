package com.mycompany.torneofutbol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("Torneo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1050, 760);
        stage.setTitle("Sistema de Gestión de Torneos de Fútbol");
        stage.setScene(scene);
        stage.setMinWidth(900);
        stage.setMinHeight(650);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
