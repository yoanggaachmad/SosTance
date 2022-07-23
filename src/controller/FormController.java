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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.*;
import openscene.*;

/**
 *
 * @author arulh
 */
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FormController implements Initializable {

    @FXML
    private TextField NamaLengkap;

    @FXML
    private RadioButton jens;

    @FXML
    private RadioButton perm;

    @FXML
    private ChoiceBox Agama;

    @FXML
    private TextField Alamat;

    @FXML
    private TextField NIK;

    @FXML
    private TextField KK;

    @FXML
    private ChoiceBox pekerjaan;

    @FXML
    private Button simpan;

    @FXML
    private Button tampilkan;

    private String pekerjaanm, Agamam, NamaLengkapm, NIKm, KKm, Alamatm, RadioButn;
    ListIsiFormulir listformulir;//deklarasi class observable list
    LinkedList<IsiFormulir> simpanFormulir = new LinkedList<>();//buat larik dari kelas model Isiformulir

    @FXML
    private void ButtonTampilkanData(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TableListFormulir.fxml"));//load view file fxml sesuai nama yang dituliskan
        Parent scene2 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene2));
        stage.show();
        stage.setTitle("Data Pendaftar Formulir");//beri judul window
        
        Image image = new Image("Gambar/social-care.png");//tulis nama gambar yang akan dijadikan icon
        stage.getIcons().add(image);//menampilkan gambar tersebut sebagai icon
    }

    void bukaData() {
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream berkasMasuk;//buka file
        try {
            berkasMasuk = new FileInputStream("ListTempatFormulir.xml");//membuka file xml pastikan nama nya sesuai waktu menyimpan file xml nya
            int isi;
            char c;
            String s = "";// isi file dikembalikan menjadi string
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;//ubah biner ke string, string disimpan ke larik
                s = s + c;
            }
            simpanFormulir = (LinkedList<IsiFormulir>) xstream.fromXML(s);//dari string ke larik
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    @FXML
    private void ButtonSimpan(ActionEvent event) throws IOException {
        XStream xstream = new XStream(new StaxDriver());

        String tTipe = "";
        if (jens.isSelected()) {
            tTipe = "Laki laki";
        } else if (perm.isSelected()) {
            tTipe = "Perempuan";
        }
        pekerjaanm = pekerjaan.getValue().toString();
        Agamam = Agama.getValue().toString();
        NamaLengkapm = NamaLengkap.getText();
        NIKm = NIK.getText();
        KKm = KK.getText();
        Alamatm = Alamat.getText();

        System.out.println(pekerjaan);
        System.out.println(Agama);
        System.out.println(NamaLengkap);
        System.out.println(NIK);
        System.out.println(KK);
        System.out.println(Alamat);

        RadioButn = tTipe;
        System.out.println(RadioButn);

        simpanFormulir.add(new IsiFormulir(pekerjaanm, Agamam, NamaLengkapm, NIKm, KKm, Alamatm, RadioButn));
        String xml = xstream.toXML(simpanFormulir);
        FileOutputStream outDoc;
        try {// mengubah karakter penyusun string xml sebagai 
            // bytes (berbentuk nomor2 kode ASCII
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListTempatFormulir.xml");// membuat nama file & folder tempat menyimpan jika perlu
            outDoc.write(data);
            outDoc.close();
        } catch (Exception io) {
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }
    
    @FXML
    private void Chart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ChartClass.fxml"));
        Parent scene2 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene2));
        stage.show();
        stage.setTitle("Diagram Profesi");
        
        Image image = new Image("Gambar/social-care.png");
        stage.getIcons().add(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        bukaData();
        
        Agama.setValue("Islam");
        Agama.getItems().addAll("Islam", "Kristen", "Katolik", "Hindu", "Buddha", "Konghucu");

        pekerjaan.setValue("Tidak Bekerja");
        pekerjaan.getItems().addAll("Tidak Bekerja", "Petani", "Nelayan", "Buruh", "Swasta", "Lainnya");
    }

}
