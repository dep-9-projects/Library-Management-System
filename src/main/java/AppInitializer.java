import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = this.getClass().getResource("/view/SplashScreenForm.fxml");
        Parent container = FXMLLoader.load(resource);
        Scene SplashScene = new Scene(container);
        primaryStage.setScene(SplashScene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.centerOnScreen();
        primaryStage.show();


    }
}
