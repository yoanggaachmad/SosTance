/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ROG
 */
public class ListIsiTempatUsaha {
    private ObservableList<IsiTempatUsaha> listTempat;
    
    public ListIsiTempatUsaha(){
        listTempat = FXCollections.observableArrayList();
        
    }
    public ObservableList<IsiTempatUsaha> getListDataTempat() {
        return this.listTempat;
    }    

    public void setData(String provinsi, String kabupaten, String kota, String kecamatan, String kelurahan, String alamat, String tipe){
        listTempat.add(new IsiTempatUsaha(provinsi, kabupaten, kota, kecamatan, kelurahan, alamat, tipe));
    }
    
//    public void showData(){
//        for (int i = 0 ; i< 1 ; i++){
//            System.out.println(listTempat.toString());
//        }
//    }
}
