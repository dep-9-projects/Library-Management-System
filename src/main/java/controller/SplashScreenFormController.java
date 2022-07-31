package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.EventListener;

public class SplashScreenFormController {

    public Label lblLoading;
    public Rectangle rctContainer;
    public Rectangle rctStatus;

    public void initialize(){
        Timeline timeline = new Timeline();

        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Loading data..");
                rctStatus.setWidth(rctStatus.getWidth()+30);
            }
        });
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(750), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Loading Resources..");
                rctStatus.setWidth(rctStatus.getWidth()+50);
            }
        });
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Loading Database..");
                rctStatus.setWidth(rctStatus.getWidth()+65);
            }
        });
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(1200), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Initializing UI..");
                rctStatus.setWidth(rctStatus.getWidth()+70);
            }
        });
        KeyFrame keyFrame5 = new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Welcome");
                rctStatus.setWidth(rctContainer.getWidth());


                try {
                    URL resource = this.getClass().getResource("/view/HomeForm.fxml");
                    AnchorPane container = FXMLLoader.load(resource);

                    AnchorPane pneContainer = (AnchorPane)container.lookup("#pneContainer");
                    Navigation.init(pneContainer);
                    Scene scene =new Scene(container);
                    Stage homeStage =new Stage();
                    homeStage.setScene(scene);
                    homeStage.centerOnScreen();
                    homeStage.setTitle("Home");
                    homeStage.show();
                    lblLoading.getScene().getWindow().hide();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4,keyFrame5);
        timeline.playFromStart();


    }
}
