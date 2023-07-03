/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.grupo_06;

import Modelos.Usuario;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class BienvenidaController implements Initializable {
    
    Usuario u=PrimaryController.devolverUsuario();
    @FXML
    Label lbBienvenida;
    @FXML
    Button btCrearEmoji;
    @FXML
    ImageView imgv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbBienvenida.setText("Bienvenid@ "+u.getNombre());
        lbBienvenida.setStyle("-fx-font-weight: bold; -fx-font-size:40; -fx-font-family: Segoe UI Black; -fx-text-fill: black ");
        try(FileInputStream input=new FileInputStream("src/main/resources/source/emojiSaludando.gif")){
            Image image=new Image(input,108, 86,false,false);
            imgv.setImage(image);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }
    }
    
    @FXML
    private void cambiarSecondaryController() throws IOException {
        App.setRoot("secondary");
    }
    
    
}
