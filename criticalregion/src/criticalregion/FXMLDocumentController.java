/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criticalregion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Marcello
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    private static boolean show;

    public void setShow(boolean show) {
        FXMLDocumentController.show = show;
    }
    
    
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
    private void mouseClickedSlideButton(MouseEvent event) throws Exception{
        show = true;
        label.setText("Entering slides...");
        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCredits.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        
        //((FXMLCreditsController) loader.getController()).setPreviousLoader());
        
        currentStage.setScene(scene);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(show)
            label.setText("Click to enter slides presentation");
    }        
}
