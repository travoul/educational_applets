/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soiiapplication.view;

import java.io.IOException;
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
 * @author Marcello
 */
public class ChooseSimulationMenuController implements Initializable {
    
    
    @FXML
    private Label aboutSimulation;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aboutSimulation.setText(soiiapplication.SOIIApplication.BUNDLE.getString("selectAnOption"));
    }
    
    @FXML
    private void backButtonClicked(MouseEvent event) throws IOException{
            Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"),soiiapplication.SOIIApplication.BUNDLE);
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
    }

    @FXML
    private void mutualClicked(MouseEvent event) throws IOException{
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Simulation.fxml"),soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        ((SimulationController) loader.getController()).setupSimulationMode(1);
        Scene scene = new Scene(root);
        currentStage.setScene(scene);
    }

    @FXML
    private void noMutualClicked(MouseEvent event) throws IOException{
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Simulation.fxml"),soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        ((SimulationController) loader.getController()).setupSimulationMode(2);
        Scene scene = new Scene(root);
        currentStage.setScene(scene);
    }

    @FXML
    private void randomClicked(MouseEvent event) throws IOException{
            Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Simulation.fxml"),soiiapplication.SOIIApplication.BUNDLE);
            Parent root = (Parent) loader.load();
            ((SimulationController) loader.getController()).setupSimulationMode(3);
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
    }
    
    @FXML
    private void mutualEntered (MouseEvent e) throws Exception {
        aboutSimulation.setText(soiiapplication.SOIIApplication.BUNDLE.getString("onMutualExclusion"));
    }
    
    @FXML
    private void noMutualEntered (MouseEvent e) throws Exception {
        aboutSimulation.setText(soiiapplication.SOIIApplication.BUNDLE.getString("onNoMutualExclusion"));
    }
    
    @FXML
    private void randomEntered (MouseEvent e) throws Exception {
        aboutSimulation.setText(soiiapplication.SOIIApplication.BUNDLE.getString("onRandom"));
    }
    
    @FXML
    private void backButtonEntered (MouseEvent e) throws Exception {
        aboutSimulation.setText(soiiapplication.SOIIApplication.BUNDLE.getString("backButtonChooseSimulationMenu"));
    }
    
    @FXML
    private void noneSelected(MouseEvent e) throws Exception {
        aboutSimulation.setText(soiiapplication.SOIIApplication.BUNDLE.getString("selectAnOption"));
    }
}
