/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sostance;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author arulh
 */
public class DataKebutuhanList {
    private ObservableList<DataKebutuhan> listKebutuhan;
    
    public DataKebutuhanList(){
        listKebutuhan = FXCollections.observableArrayList();
    }
    
    public ObservableList<DataKebutuhan> getData(){
        return this.listKebutuhan;
    }
    
    public void setData(String kebutuhan, String aksi){
        listKebutuhan.add(new DataKebutuhan(kebutuhan, aksi));
    }
    
    public void showData(){
        for (int i = 0 ; i< 1 ; i++){
            System.out.println(listKebutuhan.toString());
        }
    }
}
