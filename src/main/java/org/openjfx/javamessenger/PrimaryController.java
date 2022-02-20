package org.openjfx.javamessenger;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private Button login;
    @FXML
    private Text signupS;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToMain(ActionEvent event) throws IOException {
        App.setRoot("main");
    }

    @FXML
    private void switchToSignup(MouseEvent event) throws IOException {
        App.setRoot("signup");
    }
}
