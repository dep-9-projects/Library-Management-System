package controller;

import db.Gender;
import db.Member;
import db.MemberDB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static db.Gender.*;
import static db.Gender.FEMALE;

public class AddMemberModalFormController {

    public ImageView imgUser;
    public TextField txtID;
    public TextField txtName;
    public TextField txtAddress;
    public ComboBox<Gender> cmbGender;
    public Button btnRegister;

    public void initialize(){
        cmbGender.setItems(FXCollections.observableArrayList(FEMALE,MALE));

        cmbGender.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Gender>() {
            @Override
            public void changed(ObservableValue<? extends Gender> observableValue, Gender prev, Gender current) {
                if (prev==current) return;
                if (current==MALE){
                    InputStream resourceAsStream = getClass().getResourceAsStream("/images/Male-User.png");
                    Image maleImage=new Image(resourceAsStream);
                    imgUser.setImage(maleImage);
                } else if (current==FEMALE) {
                    InputStream resourceAsStream = getClass().getResourceAsStream("/images/female-user.png");
                    Image femaleImage=new Image(resourceAsStream);
                    imgUser.setImage(femaleImage);
                }
            }
        });



    }
    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        if (txtID.getText().isBlank()){
            Alert alert =new Alert(Alert.AlertType.ERROR,"Member ID cannot be Empty !");
            alert.setHeaderText("Please Enter an ID");
            ImageView imageView =new ImageView(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                    ("/images/1200px-Error.svg.png"))));
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);
            alert.setTitle("Error");
            txtID.requestFocus();
            alert.showAndWait();
            return;
        } else if (!MemberDB.isID(txtID.getText())) {
            Alert alert =new Alert(Alert.AlertType.ERROR,"Invalid ID !");
            alert.setHeaderText("Enter Valid ID");
            ImageView imageView =new ImageView(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                    ("/images/1200px-Error.svg.png"))));
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);
            alert.setTitle("Error");
            alert.showAndWait();
            txtID.requestFocus();
            return;
        } else if (MemberDB.findMember(txtID.getText())!=null) {
            Alert alert =new Alert(Alert.AlertType.ERROR,"ID Already exists !");
            alert.setHeaderText("Enter correct ID");
            ImageView imageView =new ImageView(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                    ("/images/1200px-Error.svg.png"))));
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);
            alert.setTitle("Error");
            alert.showAndWait();
            txtID.requestFocus();
            return;

        } else if (txtName.getText().isBlank()) {
            Alert alert =new Alert(Alert.AlertType.ERROR,"Name cannot be empty");
            alert.setHeaderText("Enter the Name..");
            ImageView imageView =new ImageView(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                    ("/images/1200px-Error.svg.png"))));
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);
            alert.setTitle("Error");
            alert.showAndWait();
            txtName.requestFocus();
            return;
        } else if (txtAddress.getText().isBlank()) {
            Alert alert =new Alert(Alert.AlertType.ERROR,"Address cannot be empty");
            alert.setHeaderText("Enter the Address..");
            ImageView imageView =new ImageView(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                    ("/images/1200px-Error.svg.png"))));
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);
            alert.setTitle("Error");
            txtAddress.requestFocus();
            alert.showAndWait();
            return;
        } else if (cmbGender.getSelectionModel().getSelectedIndex()==-1) {
            Alert alert =new Alert(Alert.AlertType.ERROR,"Gender not specified");
            alert.setHeaderText("Select Gender");
            ImageView imageView =new ImageView(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                    ("/images/1200px-Error.svg.png"))));
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);
            alert.setTitle("Error");
            txtAddress.requestFocus();
            alert.showAndWait();
            return;
        }

        Boolean confirmation = MemberDB.addMember(new Member(txtID.getText(),txtName.getText(),txtAddress.getText(),cmbGender.
                getSelectionModel().getSelectedItem()));
        if (confirmation){
            Alert alert =new Alert(Alert.AlertType.CONFIRMATION,"Registered !");
            alert.setHeaderText("SuccessFull");
            ImageView imageView =new ImageView(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                    ("/images/SuccussFull.png"))));
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);
            alert.setTitle("Confirmation");
            Navigation.navigate(Routes.MEMBER_MANAGEMENT);
            txtAddress.getScene().getWindow().hide();
        }



    }


}
