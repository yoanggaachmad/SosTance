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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.*;
import openscene.*;

/**
 *
 * @author ROG
 */
public class ModalTempatUsahaController implements Initializable {

    private String provinsi, kabupaten, kota, kecamatan, kelurahan, alamat, tipe;

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField tfProvinsi;

    @FXML
    private TextField tfKabupaten;

    @FXML
    private TextField tfKota;

    @FXML
    private TextField tfKecamatan;

    @FXML
    private TextField tfKelurahan;

    @FXML
    private TextField tfAlamat;

    @FXML
    private RadioButton rbTipeA;

    @FXML
    private RadioButton rbTipeB;

    @FXML
    private Button btDashboard;

    @FXML
    private Button btPengisianFormulir;

    @FXML
    private Button btPengajuanBantuanSosial;

    @FXML
    private Button btPengajuanBantuanModalUsaha;

    @FXML
    private Button btListKebutuhanSubsidi;

    @FXML
    private Button btPenyediaanModalTempatUsaha;

    @FXML
    private Button btSimpan;

    @FXML
    private Button btTampilkanData;

    ListIsiTempatUsaha listTempat; //deklarasi class observable list

    LinkedList<IsiTempatUsaha> simpanTempat = new LinkedList<>(); //buat larik dari kelas model IsiTempatUsaha

    @FXML
    private void ButtonTampilkanData(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TableListTempat.fxml")); //load view file fxml sesuai nama yang dituliskan
        Parent scene2 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene2));
        stage.show();
        stage.setTitle("Data Tempat Usaha"); //beri judul window

        Image image = new Image("Gambar/social-care.png"); //tulis nama gambar yang akan dijadikan icon
        stage.getIcons().add(image); //menampilkan gambar tersebut sebagai icon
    }

    void bukaData() {
        XStream xstream = new XStream(new StaxDriver()); 
        FileInputStream berkasMasuk; //buka file
        try {
            //membuka file xml pastikan nama nya sesuai waktu menyimpan file xml nya
            berkasMasuk = new FileInputStream("ListTempatUsaha.xml");
            int isi; 
            char c; 
            String s = ""; // isi file dikembalikan menjadi string
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi; //ubah biner ke string, string disimpan ke larik
                s = s + c;
            }
            simpanTempat = (LinkedList<IsiTempatUsaha>) xstream.fromXML(s); //dari string ke larik
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    @FXML
    private void ButtonSimpan(ActionEvent event) throws IOException {
        XStream xstream = new XStream(new StaxDriver());

        String tTipe = "";
        if (rbTipeA.isSelected()) {
            tTipe = "Tipe A";
        } else if (rbTipeB.isSelected()) {
            tTipe = "TipeB";
        }
        tipe = tTipe;
        System.out.println(tipe);

        //mendapatkan input dari user
        provinsi = tfProvinsi.getText();
        kabupaten = tfKabupaten.getText();
        kota = tfKota.getText();
        kelurahan = tfKelurahan.getText();
        kecamatan = tfKecamatan.getText();
        alamat = tfAlamat.getText();

        System.out.println(provinsi);
        System.out.println(kabupaten);
        System.out.println(kota);
        System.out.println(kelurahan);
        System.out.println(kecamatan);
        System.out.println(alamat);

        simpanTempat.add(new IsiTempatUsaha(provinsi, kabupaten, kota, kecamatan, kelurahan, alamat, tipe));

        String xml = xstream.toXML(simpanTempat);
        FileOutputStream outDoc;
        try {
            // mengubah karakter penyusun string xml sebagai 
            // bytes (berbentuk nomor2 kode ASCII
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListTempatUsaha.xml");  // membuat nama file & folder tempat menyimpan jika perlu
            outDoc.write(data); //Menyimpan file dari bytes
            outDoc.close();
        } catch (Exception io) {
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaData();
    }

}
