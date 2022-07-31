package controller;

import db.Book;
import db.Member;
import db.MemberDB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MembersManagementFormController {

    public Button btnBack;
    public Button btnAddMember;
    public TextField txtSearchMember;
    public TableView<Member> tblMembers;

    public void initialize(){
        tblMembers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblMembers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMembers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblMembers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));

        tblMembers.setItems(FXCollections.observableArrayList(MemberDB.getMemberDatabase()));


        txtSearchMember.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String previous, String current) {
                if (previous.equals(current)) return;
                tblMembers.setItems(FXCollections.observableArrayList(MemberDB.searchMembers(current)));
                tblMembers.refresh();

            }
        });



        tblMembers.setRowFactory(tv -> {
            TableRow<Member> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Member selectedMember = row.getItem();

                    try {
                        URL resource = this.getClass().getResource("/view/UpdateMemberForm.fxml");
                        FXMLLoader fxmlLoader = new FXMLLoader(resource);
                        Parent updateFormContainer = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(updateFormContainer));
                        stage.initModality(Modality.APPLICATION_MODAL);
                        UpdateMemberFormController updateMemberFormController = fxmlLoader.getController();
                        updateMemberFormController.init(selectedMember);


                        stage.show();
                        stage.centerOnScreen();
                        stage.setTitle(selectedMember.getName());


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            });
            return row ;
        });

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN_DASHBOARD);
    }

    public void btnAddMemberOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/AddMemberModalForm.fxml");
        Parent container = FXMLLoader.load(resource);
        Stage stage = new Stage();
        stage.setScene(new Scene(container));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.centerOnScreen();
        stage.setTitle("Member Registration");
        stage.setResizable(false);
        stage.show();

    }
}
