/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openscene;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import controller.*;
import main.LoginSostance;

public class OpenScene {
    private Pane halaman;
    
    public Pane getPane(String fileName){
        try{
            URL fileHalaman = LoginSostance.class.getResource(fileName+".fxml");
            
            if(fileHalaman==null){
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }
            halaman = new FXMLLoader().load(fileHalaman);
        }catch (Exception e){
            System.err.println("Perhatian: " + e.getMessage());
            System.out.println("Tidak ditemukan halaman tersebut");
        }
        return halaman;
    }
}
