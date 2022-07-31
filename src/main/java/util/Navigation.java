package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class Navigation {

    public static AnchorPane pneContainer;

    public static void init(AnchorPane pneContainer){
        Navigation.pneContainer =pneContainer;
    }

    public static Object navigate(Routes route) throws IOException {
        pneContainer.getChildren().clear();
        Stage window = (Stage)pneContainer.getScene().getWindow();
        URL resource = null;
        switch (route){
            case LOGIN:
                resource = Navigation.class.getResource("/view/LoginForm.fxml");
                window.setTitle("Library Management System-Login");
                break;

            case ADMIN_DASHBOARD:
                resource = Navigation.class.getResource("/view/AdminForm.fxml");
                window.setTitle("Library Management System-DashBoard");
                break;

            case BOOKS_MANAGEMENT:
                resource = Navigation.class.getResource("/view/BooksManagementForm.fxml");
                window.setTitle("Library Management System-Books Management");
                break;

            case WELCOME:
                resource = Navigation.class.getResource("/view/WelcomeForm.fxml");
                window.setTitle("Library Management System");
                break;

            case BOOK_ISSUE:
                resource =Navigation.class.getResource("/view/BookIssueForm.fxml");
                window.setTitle("Library Management System-Issue Book");
                break;

            case BOOK_RETURN:
                resource = Navigation.class.getResource("/view/BookReturnForm.fxml");
                window.setTitle("Library Management System-Return Book");
                break;

            case MEMBER_MANAGEMENT:
                resource = Navigation.class.getResource("/view/MembersManagementForm.fxml");
                window.setTitle("Library Management System-Members Management");
                break;

            default:
                resource = Navigation.class.getResource("/view/AdminSettingsForm.fxml");
                window.setTitle("Library Management System-Settings");
                break;





        }

        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        AnchorPane container =fxmlLoader.load();
        pneContainer.getChildren().add(container);
        AnchorPane.setBottomAnchor(container,0.0);
        AnchorPane.setTopAnchor(container,0.0);
        AnchorPane.setRightAnchor(container,0.0);
        AnchorPane.setLeftAnchor(container,0.0);
        return fxmlLoader.getController();
    }
}
