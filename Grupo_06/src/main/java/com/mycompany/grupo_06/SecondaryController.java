package com.mycompany.grupo_06;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import tdas.LCD;


public class SecondaryController {
    
    @FXML
    StackPane panelEmoji = new StackPane();
    @FXML
    Button RandomButton;
    
    @FXML
    private void setImage(){
        System.out.println("UWU");
        
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
        LCD<Integer> lista = new LCD();
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        System.out.println(lista.get(0));
    }
}