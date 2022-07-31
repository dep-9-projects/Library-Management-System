package controller;

import db.Gender;
import db.Member;
import db.MemberDB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import util.Navigation;
import util.Routes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class UpdateMemberFormController {
    public AnchorPane pneCard;
    public ImageView imgQR;
    public ImageView imgUser;
    public TextField txtName;
    public TextField txtAddress;
    public ComboBox cmbGender;
    public Label lblIndex;
    public Button btnUpdate;
    public Button btnRemove;
    public Button btnPrint;
    private Member selectedMember;
    public void init(Member selectedMember) {
        this.selectedMember =selectedMember;

        lblIndex.setText(selectedMember.getId());
        txtName.setText(selectedMember.getName());
        txtAddress.setText(selectedMember.getAddress());
        cmbGender.setItems(FXCollections.observableArrayList(Gender.FEMALE,Gender.MALE));
        cmbGender.getSelectionModel().select(selectedMember.getGender());
        if (selectedMember.getGender()==Gender.FEMALE) imgUser.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                ("/images/female-user.png"))));

        cmbGender.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object prev, Object curr) {
                if (prev==curr) return;
                else if (curr==Gender.FEMALE){
                    imgUser.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                            ("/images/female-user.png"))));
                }else{
                    imgUser.setImage(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream
                            ("/images/Male-User.png"))));
                }
            }
        });

    }

    public void lblIndexOnMouseClicked(MouseEvent mouseEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        if (txtName.getText().isBlank() || txtAddress.getText().isBlank() || cmbGender.getSelectionModel().getSelectedIndex()==-1){
            new Alert(Alert.AlertType.ERROR,"Invalid details ").show();
            return;
        }
        selectedMember.setName(txtName.getText());
        selectedMember.setAddress(txtAddress.getText());
        selectedMember.setGender((Gender) cmbGender.getSelectionModel().getSelectedItem());
        Navigation.navigate(Routes.MEMBER_MANAGEMENT);
        txtAddress.getScene().getWindow().hide();
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) throws IOException {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete member ?",ButtonType.YES,ButtonType.NO).showAndWait();
        if (buttonType.get()==ButtonType.NO){
            txtAddress.getScene().getWindow().hide();
            return;
        } else if (buttonType.get()==ButtonType.YES) {
            MemberDB.removeMember(selectedMember);
            txtName.getScene().getWindow().hide();
            Navigation.navigate(Routes.MEMBER_MANAGEMENT);
        }

    }

    public void btnPrintOnAction(ActionEvent actionEvent) throws IOException {
       /* FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Member ID");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setInitialFileName(selectedMember.getId()+"_.jpeg");
        fileChooser.getExtensionFilters().
                add(new FileChooser.ExtensionFilter("PNG Files (*.jpeg)", "*.jpeg"));
        File saveLocation = fileChooser.showSaveDialog(txtName.getScene().getWindow());
        BufferedImage bufferedQRImage = SwingFXUtils.fromFXImage(pneCard, null);
        boolean saved = ImageIO.write(bufferedQRImage, "jpeg", saveLocation);
        if (saved){
            new Alert(Alert.AlertType.INFORMATION, "Downloaded").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "Failed to download").show();
        }*/
    }
}
