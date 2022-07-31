package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import util.Navigation;
import util.Routes;

import java.io.IOException;

public class LoginFormController {

    private String adminPassword="Pradeep@dep9";

    public TextField txtPassword;
    public Button btnLogin;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if (txtPassword.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Password field cannot be empty!").showAndWait();
            return;
        } else if ( !txtPassword.getText().equals(adminPassword)) {
            new Alert(Alert.AlertType.ERROR,"Invalid Password!").showAndWait();
            return;
        }
        Navigation.navigate(Routes.ADMIN_DASHBOARD);

    }
}
