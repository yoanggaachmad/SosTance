/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sostance;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ROG
 */
public class TableSubsidiController implements Initializable {

    @FXML
    private TableView<DataKebutuhan> tvData;

    @FXML
    private TableColumn<DataKebutuhan, String> tcKebutuhan;

    @FXML
    private TableColumn<DataKebutuhan, String> tcTambah;

    ObservableList dataKebutuhanList = observableArrayList();

    LinkedList<DataKebutuhan> dataKebutuhan = new LinkedList<>();

    XStream xstream = new XStream(new StaxDriver());
    void bukaData() {
        FileInputStream berkasMasuk;
        try {
            berkasMasuk = new FileInputStream("ListKebutuhan.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;
                s = s + c;
            }
            dataKebutuhan = (LinkedList<DataKebutuhan>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    void simpanData() {
        String xml = xstream.toXML(dataKebutuhan);
        FileOutputStream outDoc;
        try {
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("ListKebutuhan.xml");
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
            dataKebutuhanList.remove(i);
            dataKebutuhan.remove(i);
        }
        
        simpanData();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcKebutuhan.setCellValueFactory(new PropertyValueFactory<>("kebutuhan"));
        tcTambah.setCellValueFactory(new PropertyValueFactory<>("aksi"));
        
        bukaData();
        simpanData();
        
        for (int i = 0; i < dataKebutuhan.size(); i++) {
            dataKebutuhanList.add(dataKebutuhan.get(i));
        }
        
        tvData.setItems(dataKebutuhanList);
    }    
    
}
