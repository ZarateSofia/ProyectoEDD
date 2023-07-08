package com.mycompany.grupo_06;

import Modelos.Emoji;
import Modelos.Seleccionador;
import Modelos.Usuario;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
    
    
    
    LCD<ImageView> Caras;
    LCD<ImageView> Bocas;
    LCD<ImageView> Ojos;
    
    Emoji emoji;
    
    int indiceCara;
    int indiceBoca;
    int indiceOjos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        indiceCara = 0;
        indiceBoca = 0;
        indiceOjos = 0;
        Caras = cargarCaras();
        Bocas = cargarBocas();
        Ojos = cargarOjos();
        emoji = BienvenidaController.devolverEmoji();
        
        mostrarPartes(Caras, indiceCara, listadoCaras, 1);
        mostrarPartes(Bocas, indiceBoca, listadoBocas, 2);
        mostrarPartes(Ojos, indiceOjos, listadoOjos, 3);
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
    
    public ImageView generarFlechas(boolean Der, String ruta, int indice, LCD<ImageView> lista, HBox hb, int parte){
        Image img = new Image(ruta, 45, 45, true, false);
        ImageView iv = new ImageView(img);
        EventHandler<MouseEvent> evento = new EventHandler(){
            @Override
            public void handle(Event t) {
                if(Der){
                    nextElement(indice, lista, hb, parte);
                } else{
                    prevElement(indice, lista, hb, parte);
                }   
            }   
        };
        iv.setOnMouseClicked(evento);        
        return iv;
    }
    
    public ImageView generarPartes(LCD<ImageView> lista, int index, int pos){
        ImageView iv;
        switch (pos) {
            case -2:
                iv = lista.getPrevTooElement(index);
                break;
            case -1:
                iv = lista.getPrevElement(index);
                break;
            case 1:
                iv = lista.getNextElement(index);
                break;
            default:
                iv = lista.getNextTooElement(index);
                break;
        }
        return iv;
    }
    
    public void setIndice(int indice, int x){
        indice = x;
    }
    
    public int alterarIndice(int indice, int pos, int length){
        int x = indice + pos;
        
        if(x<0){
            x = length + x;
            setIndice(indice, x);
            return x;
        } else if(x>=length){
            x = x - length;
            setIndice(indice, x);
            return x;
        }
        
        else{
            setIndice(indice, x);
            return x;
        }
    }
    
    public ImageView eventosPartes(int pos, int indice, LCD<ImageView> lista, HBox hb, int parte){
        EventHandler<MouseEvent> evento;
        ImageView iv = generarPartes(lista, indice, pos);
        
        evento = new EventHandler(){
            
            public int index;
            
            @Override
            public void handle(Event t) {
                System.out.println("UwU");
                int length = lista.size();
                int x = alterarIndice(indice, pos, length);
                hb.getChildren().clear();
                mostrarPartes(lista, x, hb, parte);
            }
            
        };
        iv.setOnMouseClicked(evento);
        
        return iv;
    }
    
    private void construirEmoji(){
        panelEmoji.getChildren().clear();
        
        ImageView ivCuerpo = emoji.setImageCuerpo();
        ImageView ivBoca = emoji.setImageBoca();
        ImageView ivOjos = emoji.setImageOjos();
        
        ivOjos.setTranslateY(-10);
        ivBoca.setTranslateY(15);
        
        panelEmoji.getChildren().add(ivCuerpo);
        panelEmoji.getChildren().add(ivBoca);
        panelEmoji.getChildren().add(ivOjos);
        
        
    }
    public void mostrarPartes(LCD<ImageView> lista, int indice, HBox hb, int parte){
        if(indice == lista.size()){
            indice = 0;
        } else if (indice == -1){
            indice = lista.size();
        }
        
        //Flecha Derecha
        File rutaFile = new File("src/main/resources/source/flechaDer.png") ;
        String ruta = rutaFile.toURI().toString();
        ImageView derecha = generarFlechas(true, ruta, indice, lista,hb, parte);
        
        //Flecha Izquierda
        rutaFile = new File("src/main/resources/source/flechaIzq.png");
        ruta = rutaFile.toURI().toString();
        ImageView izquierda = generarFlechas(false, ruta, indice, lista, hb, parte);
        
        ImageView img1 = eventosPartes(-2, indice, lista, hb, parte);
        ImageView img2 = eventosPartes(-1, indice, lista, hb, parte);
        ImageView img3 = eventosPartes(1, indice, lista, hb, parte);
        ImageView img4 = eventosPartes(2, indice, lista, hb, parte);
        ImageView imgPrincipal = lista.get(indice);

        hb.getChildren().add(izquierda);
        hb.getChildren().add(img1);
        hb.getChildren().add(img2);
        hb.getChildren().add(imgPrincipal);
        hb.getChildren().add(img3);
        hb.getChildren().add(img4);
        hb.getChildren().add(derecha);
        
        emoji.settearPartes(imgPrincipal.getImage().getUrl(), parte);
        construirEmoji();
    }
    
    private void nextElement(int indice, LCD<ImageView> lista, HBox hb, int parte){
        indice++;
        hb.getChildren().clear();
        mostrarPartes(lista, indice, hb, parte);
        System.out.println("NextElement: "+ indiceCara);

    }
    
    private void prevElement(int indice, LCD<ImageView> lista, HBox hb, int parte){
        indice--;
        hb.getChildren().clear();
        mostrarPartes(lista, indice, hb, parte);
        System.out.println("PrevElement: " + indiceCara);
    }
    
   
    
    @FXML
    private void eliminarParte() throws IOException{
        System.out.println("Metodo Eliminar Parte: "+indiceCara);
        //Caras.remove(indiceCara);
//        indiceCara = 0;
//        listadoCaras.getChildren().clear();
        //mostrarPartes(Caras, indiceCara, listadoCaras);
        
    }
    
    @FXML
    private void guardarEmoji() throws IOException{
        Usuario u = PrimaryController.devolverUsuario();
        u.agregarEmoji(emoji);
        Usuario.escribirLista(PrimaryController.listaUsuarios);
        App.setRoot("Bienvenida");
    }
    
    @FXML
    private void emojiRandom() throws IOException{
        Random rand = new Random();
        indiceCara = rand.nextInt(Caras.size());
        indiceBoca = rand.nextInt(Bocas.size());
        indiceOjos = rand.nextInt(Ojos.size());
        
        listadoCaras.getChildren().clear();
        listadoBocas.getChildren().clear();
        listadoOjos.getChildren().clear();
        
        mostrarPartes(Caras, indiceCara, listadoCaras, 1);
        mostrarPartes(Bocas, indiceBoca, listadoBocas, 2);
        mostrarPartes(Ojos, indiceOjos, listadoOjos, 3);
    }
    
    
    @FXML
    private void seleccionarCara() throws IOException{
        Seleccionador sc = new Seleccionador();
        sc.seleccionarComponente(Caras);
        listadoCaras.getChildren().clear();
        mostrarPartes(Caras, indiceCara, listadoCaras, 1);
    }
    
    @FXML
    private void seleccionarBoca() throws IOException{
        Seleccionador sc = new Seleccionador();
        sc.seleccionarComponente(Bocas);
        listadoBocas.getChildren().clear();
        mostrarPartes(Bocas, indiceBoca, listadoBocas, 2);
    }
    
    @FXML
    private void seleccionarOjos() throws IOException{
        Seleccionador sc = new Seleccionador();
        sc.seleccionarComponente(Ojos);
        listadoOjos.getChildren().clear();
        mostrarPartes(Ojos, indiceOjos, listadoOjos, 3);
    }
    
     @FXML
    private void switchToPrimary() throws IOException {
        //App.setRoot("primary");
        LCD<Integer> lista = new LCD();
        lista.get(-1);
    }
    
}