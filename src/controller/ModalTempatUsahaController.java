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
    LinkedList<IsiTempatUsaha> simpanTempat = new LinkedList<>();
    
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
    
    ListIsiTempatUsaha listTempat;
    
    
    @FXML
    private void ButtonTampilkanData(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TableListTempat.fxml"));
        Parent scene2 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene2));
        stage.show();
        stage.setTitle("Data Tempat Usaha");
        
        Image image = new Image("Gambar/social-care.png");
        stage.getIcons().add(image);
    }
    
    void bukaData() {
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream berkasMasuk;
        try {
            berkasMasuk = new FileInputStream("ListTempatUsaha.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;
                s = s + c;
            }
            simpanTempat = (LinkedList<IsiTempatUsaha>) xstream.fromXML(s);
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
        }else if(rbTipeB.isSelected()){
            tTipe = "TipeB";
        }
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
        
        tipe = tTipe;
        System.out.println(tipe);
        
        simpanTempat.add(new IsiTempatUsaha(provinsi, kabupaten, kota, kecamatan, kelurahan, alamat, tipe));
        
        String xml = xstream.toXML(simpanTempat);
        FileOutputStream outDoc;
        try{
            byte[]data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListTempatUsaha.xml");
            outDoc.write(data);
            outDoc.close();
        } catch(Exception io){
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaData();
    }    
    
}
