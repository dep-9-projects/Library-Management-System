package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import util.Navigation;
import util.Routes;

import java.io.IOException;

public class AdminFormController {

    public Button btnManageBooks;

    public void btnManageBooksOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.BOOKS_MANAGEMENT);

    }
}
