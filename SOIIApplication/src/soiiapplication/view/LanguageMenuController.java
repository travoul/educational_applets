/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soiiapplication.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Marcello
 */
public class LanguageMenuController implements Initializable {
    
    @FXML
    private Label languagePort;
    @FXML
    private Label languageEng;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        languagePort.setText("Português");
        languageEng.setText("English");
    }    
    
}
