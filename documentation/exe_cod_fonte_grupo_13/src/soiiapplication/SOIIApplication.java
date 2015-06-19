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
package soiiapplication;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SOIIApplication extends Application {

    public static ResourceBundle BUNDLE;
    public static Stage primaryStage;

    // start() method creates stage and starts application
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Critical Region and Mutual Exclusion Open Educational Resource");
        this.primaryStage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        this.primaryStage.setMinHeight(650);
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

    public void closeProgram() {
        this.primaryStage.close();
    }
}
