/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import com.mycompany.grupo_06.App;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import tdas.LCD;

/**
 *
 * @author USER
 */
public class Seleccionador {
     private FileChooser fileChooser;
     
     public Seleccionador(){
         fileChooser = new FileChooser();
     }
     
     public void seleccionarComponente(LCD<Image> lista, StackPane pn){
         fileChooser.setTitle("Seleccionar un componente");
         ExtensionFilter extensionFilter = new ExtensionFilter("Archivos PNG", "*.png");
         fileChooser.getExtensionFilters().add(extensionFilter);
         
         File selectedFile = fileChooser.showOpenDialog(App.getScene().getWindow());
         if (selectedFile != null) {
            // Hacer algo con el archivo seleccionado
            
            try{
                System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
                Image img = new Image(selectedFile.toURI().toString());
                ImageView imgv = new ImageView(img);
                pn.getChildren().add(imgv);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
              
        }
         
     }
     
     //Terminar
     public File seleccionarCarpeta(){
         fileChooser.setTitle("Guardar Emoji");
         fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivo PNG", "*.png"));
         File file = fileChooser.showSaveDialog(App.getScene().getWindow());
         return file;
     }
}
