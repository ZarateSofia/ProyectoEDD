package com.mycompany.grupo_06;

import Modelos.Seleccionador;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import tdas.LCD;


public class SecondaryController {
    
    @FXML
    StackPane panelEmoji;
    @FXML
    Button RandomButton;
    
    @FXML
    private void setImage(){
        System.out.println("UWU");
        
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
    
    
    
}