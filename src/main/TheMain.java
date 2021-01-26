/**
 * @class: TheMain
 * @author: Elias Kalkhofer
 * @date: 26.01.2021
 */

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TheMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/viewcontrol/ViewColorCalculator.fxml"));
        primaryStage.setTitle("Color Calculator");
        primaryStage.getIcons().add(new Image("/images/ColorWheel.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
