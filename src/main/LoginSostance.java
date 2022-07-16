/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ROG
 */
public class LoginSostance extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginSostance.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setTitle("SosTance");
        
        Image image = new Image("Gambar/social-care.png");
        stage.getIcons().add(image);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        //NAMA ANGGOTA KELOMPOK:
        //1. SYAHARUL HAFIDZ (21523050)
        //2. PATANDYA WISNU SURAYA (21523098)
        //3. GUNTUR MAULANA PUTRA PROJO (21523149)
        //4. YOANGGA ACHMAD DWI PASANJAYA (21523235)
        
        //UNTUK USERNAME DAN PASSWORD APLIKASI KAMI DAPAT DIBUAT PADA FITUR BUAT AKUN.
        //TETAPI BERIKUT KAMI AKAN MEMBERIKAN USERNAME DAN PASSWORD YANG SUDAH KAMI BUAT
        //DAN SUDAH TERSIMPAN DI DALAM FILE XML
        //USERNAME: aaa
        //PASSWORD: aaa
    }
    
}
