package com.mycompany.grupo_06;

import Modelos.Seleccionador;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import tdas.LCD;


public class SecondaryController implements Initializable{
    
    @FXML
    StackPane panelEmoji = new StackPane();
    @FXML
    Button RandomButton;
    int imagenMax = 10;
    @FXML
    HBox listadoCaras;
    @FXML
    HBox listadoOjos;
    @FXML
    HBox listadoBocas;
    
    
    
    LCD<ImageView> Caras=cargarCaras();
    LCD<ImageView> Bocas=cargarBocas();
    LCD<ImageView> Ojos=cargarOjos();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarCarasLCD();
        mostrarOjosLCD();
        mostrarBocasLCD();
    }

    public LCD<ImageView> cargarCaras(){
        Caras=new LCD<>();
        String rutaCaras = "src/main/resources/faces/";
        System.out.println(rutaCaras);
        File folder = new File(rutaCaras);
        File listFile[]= folder.listFiles();
        if(listFile!=null){
            for (int i=0;i<imagenMax;i++) {
                String imagePath = listFile[i].toURI().toString();
                Image image = new Image(imagePath,45,45,false,true);
                ImageView imgv=new ImageView();
                imgv.setImage(image);
                System.out.println(Caras.addLast(imgv));
                System.out.println(listFile[i].getPath());
            }
        }

        return Caras;
    }   
    
    public LCD<ImageView> cargarBocas(){
        Bocas=new LCD<>();
        String rutaBocas = "src/main/resources/mouth/";
        System.out.println(rutaBocas);
        File folder = new File(rutaBocas);
        File listFile[]= folder.listFiles();
        if(listFile!=null){
            for (int i=0;i<imagenMax;i++) {
                String imagePath = listFile[i].toURI().toString();
                Image image = new Image(imagePath,45,45,false,true);
                ImageView imgv=new ImageView();
                imgv.setImage(image);
                System.out.println(Bocas.addLast(imgv));
            }
        }

        return Bocas;
    }
    
    public LCD<ImageView> cargarOjos(){
        Ojos=new LCD<>();
        String rutaOjos = "src/main/resources/eyes/";
        System.out.println(rutaOjos);
        File folder = new File(rutaOjos);
        File listFile[]= folder.listFiles();
        if(listFile!=null){
            for (int i=0;i<imagenMax;i++) {
                String imagePath = listFile[i].toURI().toString();
                Image image = new Image(imagePath,45,45,true,false);
                ImageView imgv=new ImageView();
                imgv.setImage(image);
                System.out.println(Ojos.addLast(imgv));
            }
        }

        return Ojos;
    }
    
    
    public void mostrarCarasLCD(){
        for(ImageView image:Caras){
            listadoCaras.getChildren().addAll(image);
        }       
    } 
    
    public void mostrarBocasLCD(){
        for(ImageView image:Bocas){
            listadoBocas.getChildren().addAll(image);
        }       
    }
    
    public void mostrarOjosLCD(){
        for(ImageView image:Ojos){
            listadoOjos.getChildren().addAll(image);
        }       
    }
    
     @FXML
    private void switchToPrimary() throws IOException {
        //App.setRoot("primary");
        LCD<Image> lista = new LCD();
//        lista.addLast(1);
//        lista.addLast(2);
//        lista.addLast(3);
        
        Seleccionador sl = new Seleccionador();
        sl.seleccionarComponente(lista,panelEmoji);

    }
    
    @FXML
    private void setImage(){
        System.out.println("UWU");
        
    }
    
}