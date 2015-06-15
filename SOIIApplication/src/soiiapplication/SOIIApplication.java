/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soiiapplication;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SOIIApplication extends Application {
    
    public static ResourceBundle BUNDLE;
    public static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Critical Region and Mutual Exclusion Open Educational Resource");
        this.primaryStage.setOnCloseRequest(e->{
            e.consume();
            closeProgram();
        });
        this.primaryStage.setMinHeight(600);
        this.primaryStage.setMinWidth(1000);
        
        AnchorPane root = FXMLLoader.load(getClass().getResource("view/LanguageMenu.fxml"));
        root.setId("AnchorPane");
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void closeProgram(){
        this.primaryStage.close();
    }
}
