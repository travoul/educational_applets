/* SSC0640 - Operating Systems 1
 * Institute of Mathematical and Computer Sciences
 * School of Engineering of São Carlos
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
 * FXML Controller class
 * Controller for the language menu
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
        soiiapplication.SOIIApplication.primaryStage.setTitle("Recurso Educacional Aberto - Região Crítica e Exclusão Mútua");
        mouseClicked(event);
    } 
    
    @FXML
    private void mouseClickedUSA(MouseEvent event) throws Exception {
       soiiapplication.SOIIApplication.BUNDLE = bundleEN;
       soiiapplication.SOIIApplication.primaryStage.setTitle("Critical Region and Mutual Exclusion Open Educational Resource");
       mouseClicked(event);
    }

    private void mouseClicked(MouseEvent event) throws Exception {

        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"), soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root,currentStage.getScene().getWidth(),currentStage.getScene().getHeight());
        currentStage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        languagePort.setText("Português");
        languageEng.setText("English");
    }

}
