package com.mycompany.grupo_06;

import Modelos.Seleccionador;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import tdas.LCD;


public class SecondaryController implements Initializable{
    
    @FXML
    StackPane panelEmoji;
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
    
    int indiceCara = 0;
    int indiceBoca = 0;
    int indiceOjos = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarPartes(Caras, indiceCara, listadoCaras);
        mostrarPartes(Bocas, indiceBoca, listadoBocas);
        mostrarPartes(Ojos, indiceOjos, listadoOjos);
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
    
    public ImageView generarFlechas(boolean Der, String ruta, int indice, LCD<ImageView> lista, HBox hb){
        Image img = new Image(ruta, 45, 45, true, false);
        ImageView iv = new ImageView(img);
        EventHandler<MouseEvent> evento = new EventHandler(){
            @Override
            public void handle(Event t) {
                if(Der){
                    nextElement(indice, lista, hb);
                } else{
                    prevElement(indice, lista, hb);
                }   
            }   
        };
        iv.setOnMouseClicked(evento);        
        return iv;
    }
    
    public void mostrarPartes(LCD<ImageView> lista, int indice, HBox hb){
        if(indice == lista.size()){
            indice = 0;
        } else if (indice == -1){
            indice = lista.size();
        }
        //Flecha Derecha
        File rutaFile = new File("src/main/resources/source/flechaDer.png") ;
        String ruta = rutaFile.toURI().toString();
        ImageView derecha = generarFlechas(true, ruta, indice, lista,hb);
        
        //Flecha Izquierda
        rutaFile = new File("src/main/resources/source/flechaIzq.png");
        ruta = rutaFile.toURI().toString();
        ImageView izquierda = generarFlechas(false, ruta, indice, lista, hb);
        
        ImageView img1 = lista.getPrevTooElement(indice);
        ImageView img2 = lista.getPrevElement(indice);
        ImageView img3 = lista.getNextElement(indice);
        ImageView img4 = lista.getNextTooElement(indice);
        ImageView imgPrincipal = lista.get(indice);
        
        hb.getChildren().add(izquierda);
        hb.getChildren().add(img1);
        hb.getChildren().add(img2);
        hb.getChildren().add(imgPrincipal);
        hb.getChildren().add(img3);
        hb.getChildren().add(img4);
        hb.getChildren().add(derecha);
    }
    
    private void nextElement(int indice, LCD<ImageView> lista, HBox hb){
        indice++;
        hb.getChildren().clear();
        mostrarPartes(lista, indice, hb);

    }
    
    private void prevElement(int indice, LCD<ImageView> lista, HBox hb){
        indice--;
        hb.getChildren().clear();
        mostrarPartes(lista, indice, hb);
    }
    
    private void construirEmoji(){
        panelEmoji.getChildren().clear();
        panelEmoji.getChildren().add(Caras.get(indiceCara));
    }
    
    @FXML
    private void seleccionarCara() throws IOException{
        Seleccionador sc = new Seleccionador();
        sc.seleccionarComponente(Caras);
        listadoCaras.getChildren().clear();
        mostrarPartes(Caras, indiceCara, listadoCaras);
    }
    
    @FXML
    private void seleccionarBoca() throws IOException{
        Seleccionador sc = new Seleccionador();
        sc.seleccionarComponente(Bocas);
        listadoBocas.getChildren().clear();
        mostrarPartes(Bocas, indiceBoca, listadoBocas);
    }
    
    @FXML
    private void seleccionarOjos() throws IOException{
        Seleccionador sc = new Seleccionador();
        sc.seleccionarComponente(Ojos);
        listadoOjos.getChildren().clear();
        mostrarPartes(Ojos, indiceOjos, listadoOjos);
    }
    
     @FXML
    private void switchToPrimary() throws IOException {
        //App.setRoot("primary");
        LCD<Integer> lista = new LCD();
        lista.get(-1);
        

    }
    @FXML
    private void construirEmoji(MouseEvent event){
        if(event.getSource() == listadoCaras){
            javafx.scene.Node elementoSeleccionado= listadoCaras.getChildren().get(0);
            panelEmoji.getChildren().add(elementoSeleccionado);
            if(event.getSource() == listadoOjos){
                elementoSeleccionado= listadoOjos.getChildren().get(0);
                panelEmoji.getChildren().add(elementoSeleccionado);
                if(event.getSource() == listadoBocas){
                    elementoSeleccionado= listadoBocas.getChildren().get(0);
                    panelEmoji.getChildren().add(elementoSeleccionado);
                }
            }
        }
    
}
}