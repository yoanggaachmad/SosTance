/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sostance;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author ROG
 */
public class ChartClassController implements Initializable {

    @FXML
    private BarChart<String, Integer> bcPekerjaan;
    
    LinkedList<IsiFormulir> simpanFormulir = bukaData();
    
    LinkedList<IsiFormulir> bukaData(){
    XStream xstream = new XStream(new StaxDriver());
        FileInputStream buka = null;
        try {
            // nama file yang akan dibuka (termasuk folder jika perlu
            buka = new FileInputStream("ListTempatFormulir.xml");
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
            simpanFormulir = (LinkedList<IsiFormulir>) xstream.fromXML(s);
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
        return null;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaData();
        
        //BarChart
        LinkedList<String> TidakBekerja = new LinkedList<>();
        LinkedList<String> Petani = new LinkedList<>();
        LinkedList<String> Nelayan = new LinkedList<>();
        LinkedList<String> Buruh = new LinkedList<>();
        LinkedList<String> Swasta = new LinkedList<>();
        LinkedList<String> Lainnya = new LinkedList<>();
        
        for (int i = 0; i < simpanFormulir.size(); i++) {
            if (simpanFormulir.get(i).getPekerjaanm().equals("Tidak Bekerja")) {
                TidakBekerja.add("Tidak Bekerja");
            }else if(simpanFormulir.get(i).getPekerjaanm().equals("Petani")){
                Petani.add("Petani");
            }else if(simpanFormulir.get(i).getPekerjaanm().equals("Nelayan")){
                Nelayan.add("Nelayan");
            }else if(simpanFormulir.get(i).getPekerjaanm().equals("Buruh")){
                Buruh.add("Buruh");
            }else if(simpanFormulir.get(i).getPekerjaanm().equals("Swasta")){
                Swasta.add("Swasta");
            }else{
                Lainnya.add("Lainnya");
            }
        }
        
        XYChart.Series<String, Integer> bcPekerjaanX = new XYChart.Series();
        bcPekerjaanX.getData().add(new XYChart.Data<>("Tidak Bekerja", TidakBekerja.size()));
        bcPekerjaanX.getData().add(new XYChart.Data<>("Petani", Petani.size()));
        bcPekerjaanX.getData().add(new XYChart.Data<>("Nelayan", Nelayan.size()));
        bcPekerjaanX.getData().add(new XYChart.Data<>("Buruh", Buruh.size()));
        bcPekerjaanX.getData().add(new XYChart.Data<>("Swasta", Swasta.size()));
        bcPekerjaanX.getData().add(new XYChart.Data<>("Lainnya", Lainnya.size()));
        
        bcPekerjaan.getData().addAll(bcPekerjaanX);
    }    
    
}
