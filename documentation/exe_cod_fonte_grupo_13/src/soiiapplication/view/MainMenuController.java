/* SSC0640 - Operating Systems 1
 * Institute of Mathematical and Computer Sciences
 * University of Sao Paulo
 * Project 2 - Mutual Exclusion and Critical Region Applet
 * 17/06/2015
 ***************************************************************
 * Authors
 * Guilherme Nishina Fortes 			- No. USP 7245552
 * Henrique de Almeida Machado da Silveira 	- No. USP 7961089
 * Marcello de Paula Ferreira Costa 		- No. USP 7960690
 * Sergio Yudi Takeda 				- No. USP 7572996
 ***************************************************************
 * GROUP 13
 */
package soiiapplication.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * Controller of the Main Menu
 */
public class MainMenuController implements Initializable {

    @FXML
    private Label informativeLabel;

    @FXML
    private Button language;

    @FXML
    private void mouseClickedLanguage(MouseEvent event) throws Exception {
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LanguageMenu.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root,currentStage.getScene().getWidth(),currentStage.getScene().getHeight());
        currentStage.setScene(scene);
    }

    @FXML
    private void firstButtonMouseClicked (MouseEvent event) throws Exception {
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Didyouknow.fxml"),soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root,currentStage.getScene().getWidth(),currentStage.getScene().getHeight());
        currentStage.setScene(scene);
    }
    
    @FXML
    private void secondButtonMouseClicked (MouseEvent event) throws Exception {
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseSimulationMenu.fxml"),soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root,currentStage.getScene().getWidth(),currentStage.getScene().getHeight());
        currentStage.setScene(scene);
    }

    @FXML
    private void thirdButtonMouseClicked (MouseEvent event) throws Exception {
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Credits.fxml"),soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root,currentStage.getScene().getWidth(),currentStage.getScene().getHeight());
        currentStage.setScene(scene);
    }

    @FXML
    private void firstButtonMouseEntered(MouseEvent event) throws Exception {
        informativeLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("readableInst"));
    }

    @FXML
    private void secondButtonMouseEntered (MouseEvent e) throws Exception {
        informativeLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("simulationInst"));
    }

    @FXML
    private void thirdButtonMouseEntered (MouseEvent e) throws Exception {
        informativeLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("creditsInst"));
    }

    @FXML
    private void fourthButtonMouseEntered (MouseEvent e) throws Exception {
        informativeLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("changeLanguageInst"));
    }

    @FXML
    private void allButtonsMouseExited (MouseEvent e) throws Exception {
        informativeLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("selectAnOption"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        informativeLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("selectAnOption"));
    }
}
