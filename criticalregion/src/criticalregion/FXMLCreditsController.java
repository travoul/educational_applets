/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criticalregion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author henrisilver
 */
public class FXMLCreditsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label label;

    
    @FXML
    private void mouseClickedSlideButton(MouseEvent event) throws Exception{
        
        label.setText("Entering slides...");
        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        
        currentStage.setScene(scene);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
    }    
    
}
