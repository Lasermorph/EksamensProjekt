/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.javamessenger;

import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author stefa
 */
public class PrimaryController implements Initializable {


    @FXML
    private Button login;
    @FXML
    private Text signupS;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //chatList.getItems().add(name);
        SerialPort[] ports = SerialPort.getCommPorts();
        if(ports.length == 0)
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("No Arudino Found!");
            a.setContentText("We Failed to detect an arduino...");
            a.showAndWait();
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Arduino Found!");
            String portString = "";
            for(int i = 0; i < ports.length; i++)
            {
                portString+=ports[i].getSystemPortName();
                portString+=" ";
            }
            a.setContentText("We found arduino(s) on port(s): " + portString);
            a.showAndWait();
        }
    }    
    
    @FXML
    private void switchToMain(ActionEvent event) throws IOException {
        //App.setRoot("main");
    }

    @FXML
    private void switchToSignup(MouseEvent event) throws IOException {
        //App.setRoot("signup");
    }

}
