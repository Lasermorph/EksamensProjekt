/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.javamessenger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author stefa
 */
public class SignupController implements Initializable {


    @FXML
    private Button signupNew;
    @FXML
    private ImageView leftArrow;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToMain(ActionEvent event) throws IOException {
        App.setRoot("main");
    }

    @FXML
    private void goBack(MouseEvent event) throws IOException {
        App.setRoot("primary");
    }

}
