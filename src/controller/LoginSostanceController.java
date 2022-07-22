/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;

/**
 *
 * @author ROG
 */
public class LoginSostanceController implements Initializable {

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private ImageView ivBackground;

    @FXML
    private Label warning;

    @FXML
    private void Masuk(ActionEvent event) throws IOException {
        String email = tfEmail.getText(); //menampilkan input dari user
        String password = pfPassword.getText(); //menampilkan input dari user

        bukaXML();

        for (int i = 0; i < dataRegistrasi.size(); i++) {
            if (email.equals(dataRegistrasi.get(i).getEmail()) && password.equals(dataRegistrasi.get(i).getPassword())) {
                Parent tableViewParent = FXMLLoader.load(DashBoardController.class.getResource("/view/DashBoard.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);

                //This line gets the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(tableViewScene);
                window.show();
                
                simpanData();

                System.out.println("Login Berhasil!");
            } else {
                System.out.println("Login Gagal!");
                warning.setText("Email/Password anda salah");
            }
            Parent tableViewParent = FXMLLoader.load(DashBoardController.class.getResource("/view/DashBoard.fxml"));
        }
    }

    @FXML
    private void buatAkun(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/BuatAkun.fxml"));
        Parent scene2 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene2));
        stage.show();
        stage.setTitle("Buat Akun");

        Image image = new Image("Gambar/padlock.png");
        stage.getIcons().add(image);

    }

    XStream xstream = new XStream(new StaxDriver());

    LinkedList<DataPengguna> dataRegistrasi = new LinkedList<DataPengguna>();

    void bukaXML() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("dataRegistrasi.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            dataRegistrasi = (java.util.LinkedList<DataPengguna>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Berhasil tersimpan");
    }

    void simpanData() {
        String xml = xstream.toXML(dataRegistrasi);
        FileOutputStream berkasBaru = null;
        try {
            // membuat nama file & folder tempat menyimpan jika perlu
            berkasBaru = new FileOutputStream("dataRegistrasi.xml");

            // mengubah karakter penyusun string xml sebagai 
            // bytes (berbentuk nomor2 kode ASCII
            byte[] bytes = xml.getBytes("UTF-8");

            //Menyimpan file dari bytes
            berkasBaru.write(bytes);
        } catch (Exception e) {
            System.err.println("Perhatian : " + e.getMessage());
        } finally {
            if (berkasBaru != null) {
                try {
                    berkasBaru.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
        simpanData();
    }

}
