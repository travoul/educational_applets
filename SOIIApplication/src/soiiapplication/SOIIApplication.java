/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soiiapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SOIIApplication extends Application {
    private Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Critical Mutex");
        this.primaryStage.setOnCloseRequest(e->{
            e.consume();
            closeProgram();
        });
        
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
