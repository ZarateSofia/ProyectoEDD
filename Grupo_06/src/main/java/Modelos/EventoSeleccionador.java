/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import tdas.LCD;

/**
 *
 * @author USER

 */
public class EventoSeleccionador implements EventHandler<MouseEvent>{
    
    private int index;
    private int pos;
    
    public EventoSeleccionador(int index, int pos){
        this.index = index;
        this.pos = pos;
    }
    
    public int getIndex(){
        return index;
    }
    
    public int redirigirIndex(){
        int x = index - pos;

        if(x<0){
            return index = x - pos; 
        } else{
            return index = x;
        }

    }

    @Override
    public void handle(MouseEvent t) {
        redirigirIndex();
    }
    
}
