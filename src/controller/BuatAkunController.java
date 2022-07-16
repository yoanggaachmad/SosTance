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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.*;
import openscene.*;

/**
 * FXML Controller class
 *
 * @author ROG
 */
public class BuatAkunController implements Initializable {

    @FXML
    private TextField tfBuatUser;
    
    @FXML
    private TextField tfBuatPassword;
    
    @FXML
    private TextField tfBuatEmail;
    
    @FXML
    private Button btSimpan;
    
    LinkedList<DataPengguna> dataRegistrasi = new LinkedList<>();
    XStream xstream = new XStream(new StaxDriver());
    
    void bukaXML() {
        FileInputStream buka = null;
        try {
            // nama file yang akan dibuka (termasuk folder jika perlu
            buka = new FileInputStream("dataRegistrasi.xml");
            // harus diingat objek apa yang dahulu disimpan di file 
            // program untuk membaca harus sinkron dengan program
            // yang dahulu digunakan untuk menyimpannya
            int isi;
            char c;
            // isi file dikembalikan menjadi string
            String s = "";

            while ((isi = buka.read()) != -1) {
                c = (char) isi;
                s = s + c;
            }

            // string isi file dikembalikan menjadi larik double
            dataRegistrasi = (LinkedList<DataPengguna>) xstream.fromXML(s);
        } catch (Exception e) {
            System.err.println("test : " + e.getMessage());
        } finally {
            if (buka != null) {
                try {
                    buka.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @FXML
    private void simpan(ActionEvent event) throws IOException {
        String username = tfBuatUser.getText();
        String email = tfBuatEmail.getText();
        String password = tfBuatPassword.getText();
        
        dataRegistrasi.add(new DataPengguna(username, email, password));
        
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
        }System.out.println("Data Tersimpan");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
    }    
    
}
