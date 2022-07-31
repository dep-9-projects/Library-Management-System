package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import util.Navigation;
import util.Routes;

import java.io.IOException;

public class AdminFormController {

    public Button btnManageBooks;
    public Button btnManageMembers;
    public Button btnIssue;
    public Button btnReturn;
    public Button btnSettings;

    public void btnManageBooksOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.BOOKS_MANAGEMENT);

    }

    public void btnManageMembersOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MEMBER_MANAGEMENT);

    }

    public void btnIssueOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.BOOK_ISSUE);
    }

    public void btnReturnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.BOOK_RETURN);
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SETTINGS);
    }
}
