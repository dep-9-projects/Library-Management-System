package controller;

import javafx.application.Platform;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Navigation;
import util.Routes;

import java.io.IOException;

public class HomeFormController {

    public AnchorPane pneContainer;

    public void initialize() throws IOException {
        //Navigation.init(pneContainer);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Navigation.navigate(Routes.WELCOME);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

    public void imgHomeOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.WELCOME);
    }
}
