/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Marcello
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
        Scene scene = new Scene(root);
        currentStage.setScene(scene);
    }

    @FXML
    private void firstButtonMouseClicked (MouseEvent event) throws Exception {
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Didyouknow.fxml"),soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        currentStage.setScene(scene);
    }

    @FXML
    private void thirdButtonMouseClicked (MouseEvent event) throws Exception {
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Credits.fxml"),soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
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
