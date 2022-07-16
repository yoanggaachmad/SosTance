/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class SubsidiKebutuhanList {
    
    private String nomor ;
    private String Stok ; 
    private String namabahan;
    
    
//    private ObservableList<SubsidiKebutuhan> listData;
//    
//    public SubsidiKebutuhanList(){
//        listData = FXCollections.observableArrayList();
//    }
//
//    public ObservableList<SubsidiKebutuhan> getListData() {
//        return listData;
//    }

//    public void setData(String nomor, String namaBahan, String stok, String alamatPengambilan){
//        listData.add(new SubsidiKebutuhan(nomor, namaBahan, stok, alamatPengambilan));
//        
//    }
    
//    public void setDummy(){
//        listData.add(new SubsidiKebutuhan("1", "Beras", "10 karung", "Condong Catur,Sleman"));
//        listData.add(new SubsidiKebutuhan(", "Minyak Goreng", "10 kardus", "Condong Catur,Sleman"));
//
//    }
//    

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getStok() {
        return Stok;
    }

    public void setStok(String Stok) {
        this.Stok = Stok;
    }

    public String getNamabahan() {
        return namabahan;
    }

    public void setNamabahan(String namabahan) {
        this.namabahan = namabahan;
    }

   
}
