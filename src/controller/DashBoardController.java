/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import openscene.OpenScene;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import openscene.*;

/**
 *
 * @author Lenovo
 */
public class DashBoardController implements Initializable {

    @FXML
    BorderPane mainPane;

    @FXML
    private AnchorPane ap;

//    @FXML
//    private void DashboardButtonAction(ActionEvent event) {
////        OpenScene object = new OpenScene();
////        Pane halaman = object.getPane("DB2");
////        mainPane.setCenter(halaman);
////        mainPane.requestFocus();
//
//    }
    @FXML
    void DB2Controller(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(DB2Controller.class.getResource("/view/DB2.fxml"));
        mainPane.setCenter(pane);
    }

    @FXML
    void FormController(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(FormController.class.getResource("/view/Form.fxml"));
        mainPane.setCenter(pane);
    }

    @FXML
    void ModalTempatUsaha(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(ModalTempatUsahaController.class.getResource("/view/ModalTempatUsaha.fxml"));
        mainPane.setCenter(pane);
    }


    @FXML
    void ListSubsidiKebutuhan(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(ListSubsidiKebutuhanController.class.getResource("/view/ListSubsidiKebutuhan.fxml"));
        mainPane.setCenter(pane);
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) ap.getScene().getWindow();

        Alert.AlertType type = Alert.AlertType.CONFIRMATION;
        Alert alert = new Alert(type, "");
        alert.setTitle("Pemberitahuan !");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("Tekan Ok untuk keluar/Cancel untuk membatalkan");
        alert.getDialogPane().setHeaderText("Anda yakin ingin keluar dari aplikasi ini?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.out.println("Anda berhasil keluar aplikasi");

        } else if (result.get() == ButtonType.CANCEL) {
            System.out.println("Batal keluar aplikasi");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
