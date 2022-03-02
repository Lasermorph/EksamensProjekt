package org.openjfx.javamessenger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.WindowEvent;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Stage __stage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 600, 400);
        __stage = stage;
        __stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, eh -> {
        if (SerialHandler.INSTANCE != null)
        {
            if (SerialHandler.INSTANCE.__ReadThread != null)
            {
                SerialHandler.INSTANCE.__p.closePort();
                SerialHandler.INSTANCE.__ReadThread.stop();
            }
        }
        
        });
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        
    }

}