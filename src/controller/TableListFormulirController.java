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
 * @author Lenovo
 */
public class TableListFormulirController implements Initializable {
@FXML
    private TableView <IsiFormulir>tvDataf;
    
    @FXML 
    private TableColumn <IsiFormulir, String> tcPekerjaan;
    @FXML 
    private TableColumn <IsiFormulir, String> tcAgama;
    @FXML 
    private TableColumn <IsiFormulir, String> tcNamaLengkap;
    
    @FXML 
    private TableColumn <IsiFormulir, String> tcNIK;
    @FXML 
    private TableColumn <IsiFormulir, String> tcKK;
    
    @FXML 
    private TableColumn <IsiFormulir, String> tcAlamat;
    @FXML 
    private TableColumn <IsiFormulir, String> tcRadioButn;
    
    ObservableList dataFormulir = observableArrayList();
    LinkedList<IsiFormulir> simpanFormulir = new LinkedList<>();
    XStream xstream = new XStream(new StaxDriver());
    
    
    void bukaData() {
        FileInputStream berkasMasuk;
        try {
            berkasMasuk = new FileInputStream("ListTempatFormulir.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;
                s = s + c;
            }
            simpanFormulir = (LinkedList<IsiFormulir>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    void simpanData() {
        String xml = xstream.toXML(simpanFormulir);
        FileOutputStream outDoc;
        try {
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListTempatFormulir.xml");
            outDoc.write(data);
            outDoc.close();
        } catch (Exception io) {
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }
    
    @FXML
    private void hapusButton(ActionEvent event) {
        TableView.TableViewSelectionModel selectionModel = tvDataf.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i = selectionModel.getSelectedIndex();

        if (i >= 0) {
            dataFormulir.remove(i);
            simpanFormulir.remove(i);
        }
        
        simpanData();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcPekerjaan.setCellValueFactory(new PropertyValueFactory <> ("pekerjaanm"));
        tcAgama.setCellValueFactory(new PropertyValueFactory <> ("Agamam"));
        tcNamaLengkap.setCellValueFactory(new PropertyValueFactory <> ("NamaLengkapm"));
        tcNIK.setCellValueFactory(new PropertyValueFactory <> ("NIKm"));
        tcKK.setCellValueFactory(new PropertyValueFactory <> ("KKm"));
        tcAlamat.setCellValueFactory(new PropertyValueFactory <> ("Alamatm"));
        tcRadioButn.setCellValueFactory(new PropertyValueFactory <> ("RadioButn"));
        
        bukaData();
        simpanData();
        
        for (int i = 0; i < simpanFormulir.size(); i++) {
            dataFormulir.add(simpanFormulir.get(i));
        }
        
        tvDataf.setItems(dataFormulir);

    }

}
    
