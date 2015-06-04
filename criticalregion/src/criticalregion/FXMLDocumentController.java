/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criticalregion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Marcello
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void mouseClickedExitButton(MouseEvent event) {
        Platform.exit();
    }
    
    @FXML
    private void mouseEnteredExitButton(MouseEvent event){
        label.setText("Click to exit");
    }
    
    @FXML
    private void mouseEnteredSlideButton(MouseEvent event){
        label.setText("Click to enter slides presentation");
    }
    
    @FXML
    private void mouseExitedButton(MouseEvent event){
        label.setText("Select an option");
    }
    
    @FXML
    private void mouseClickedSlideButton(MouseEvent event){
        label.setText("Entering slides...");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }        
}
