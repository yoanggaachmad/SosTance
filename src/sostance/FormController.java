/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package sostance;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



/**
 *
 * @author arulh
 */
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class FormController implements Initializable {
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    
    @FXML
    private TextField NamaLengkap;
    
    @FXML
    private RadioButton jens;
    
    @FXML
    private RadioButton perm;
    
    @FXML
    private TextField Agama;
    
    @FXML
    private TextField Alamat;
    
    @FXML
    private TextField NIK;
    
    @FXML
    private TextField KK;
    
    @FXML
    private TextField pekerjaan;
    
    @FXML
    private Button simpan;
    
    @FXML
    private Button tampilkan;
    
    
    @FXML
    private PieChart miski;
    
    private String pekerjaanm,Agamam,NamaLengkapm,NIKm,KKm,Alamatm,RadioButn;
    ListIsiFormulir listformulir;
        ArrayList<IsiFormulir> simpanFormulir = new ArrayList<>();

    
    @FXML
    private void ButtonTampilkanData(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TableListFormulir.fxml"));
        Parent scene2 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene2));
        stage.show();
    }
     void bukaData() {
        XStream xstream = new XStream(new StaxDriver());
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
            simpanFormulir = (ArrayList<IsiFormulir>) xstream.fromXML(s);
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
        }else if(perm.isSelected()){
            tTipe = "Perempuan";
        }
        pekerjaanm = pekerjaan.getText();
        Agamam = Agama.getText();
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
        try{
            byte[]data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListTempatFormulir.xml");
            outDoc.write(data);
            outDoc.close();
        } catch(Exception io){
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listformulir = new ListIsiFormulir();
        data.add(new PieChart.Data("2010",2880));
        data.add(new PieChart.Data("2011",3230));
        data.add(new PieChart.Data("2012",3580));
        data.add(new PieChart.Data("2013",3850));
        data.add(new PieChart.Data("2014",4250));
        bukaData();
        miski.setData(data);
    }    
    
}
