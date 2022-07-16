/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import openscene.*;

/**
 * FXML Controller class
 *
 * @author ROG
 */
public class TableListTempatController implements Initializable {

    @FXML
    private Button edit;

    @FXML
    private TableView<IsiTempatUsaha> tvData;

    @FXML
    private TableColumn<IsiTempatUsaha, String> tcProvinsi;

    @FXML
    private TableColumn<IsiTempatUsaha, String> tcKabupaten;

    @FXML
    private TableColumn<IsiTempatUsaha, String> tcKota;

    @FXML
    private TableColumn<IsiTempatUsaha, String> tcKecamatan;

    @FXML
    private TableColumn<IsiTempatUsaha, String> tcKelurahan;

    @FXML
    private TableColumn<IsiTempatUsaha, String> tcAlamat;

    @FXML
    private TableColumn<IsiTempatUsaha, String> tcTipe;

    ObservableList dataTempat = observableArrayList();


    LinkedList<IsiTempatUsaha> simpanTempat = new LinkedList<>();

    XStream xstream = new XStream(new StaxDriver());

    void bukaData() {
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

    void simpanData() {
        String xml = xstream.toXML(simpanTempat);
        FileOutputStream outDoc;
        try {
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListTempatUsaha.xml");
            outDoc.write(data);
            outDoc.close();
        } catch (Exception io) {
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }
    
    @FXML
    private void hapusButton(ActionEvent event) {
        TableView.TableViewSelectionModel selectionModel = tvData.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i = selectionModel.getSelectedIndex();

        if (i >= 0) {
            dataTempat.remove(i);
            simpanTempat.remove(i);
        }
        
        simpanData();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcProvinsi.setCellValueFactory(new PropertyValueFactory<>("provinsi"));
        tcKabupaten.setCellValueFactory(new PropertyValueFactory<>("kabupaten"));
        tcKota.setCellValueFactory(new PropertyValueFactory<>("kota"));
        tcKecamatan.setCellValueFactory(new PropertyValueFactory<>("kecamatan"));
        tcKelurahan.setCellValueFactory(new PropertyValueFactory<>("kelurahan"));
        tcAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        tcTipe.setCellValueFactory(new PropertyValueFactory<>("tipe"));

        bukaData();
        simpanData();
        
        for (int i = 0; i < simpanTempat.size(); i++) {
            dataTempat.add(simpanTempat.get(i));
        }
        
        tvData.setItems(dataTempat);

    }

}
