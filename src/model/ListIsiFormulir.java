/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class ListIsiFormulir {
     private ObservableList<IsiFormulir> listformulir;
    
    public ListIsiFormulir(){
        listformulir = FXCollections.observableArrayList();
        
    }
    public ObservableList<IsiFormulir> getListDataFormulir() {
        return this.listformulir;
    }    

    public void setData(String pekerjaanm, String Agamam, String NamaLengkapm, String NIKm, String KKm, String Alamatm, String RadioButn){
        listformulir.add(new IsiFormulir(pekerjaanm, Agamam, NamaLengkapm, NIKm, KKm, Alamatm, RadioButn));
    }
    
    public void showData(){
        for (int i = 0 ; i< 1 ; i++){
            System.out.println(listformulir.toString());
        }
    }
}

