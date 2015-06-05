/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soiiapplication.view;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Marcello
 */
public class LanguageMenuController implements Initializable {

    ResourceBundle bundlePT = ResourceBundle.getBundle("soiiapplication.bundle", Locale.forLanguageTag("pt"));
    ResourceBundle bundleEN = ResourceBundle.getBundle("soiiapplication.bundle", Locale.forLanguageTag("en"));

   
    @FXML
    private ImageView usaFlag;

    @FXML
    private Label languagePort;

    @FXML
    private ImageView braFlag;

    @FXML
    private Label languageEng;

    @FXML
    private void mouseClickedBra(MouseEvent event) throws Exception {
        soiiapplication.SOIIApplication.BUNDLE = bundlePT;
        
        mouseClicked(event);
    } 
    
    @FXML
    private void mouseClickedUSA(MouseEvent event) throws Exception {
       soiiapplication.SOIIApplication.BUNDLE = bundleEN;
        mouseClicked(event);
    }

    private void mouseClicked(MouseEvent event) throws Exception {

        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"), soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        currentStage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        languagePort.setText("Português");
        languageEng.setText("English");
    }

}
