/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;

/**
 *
 * @author USER
 */
public class Exportador {
    WritableImage wi;
    
    public Exportador(StackPane panel){
        BigDecimal Bwidth = BigDecimal.valueOf(panel.getWidth());
        BigDecimal Bheight = BigDecimal.valueOf(panel.getHeight());
        
        int width = Bwidth.setScale(0, RoundingMode.HALF_UP).intValue();
        int height = Bheight.setScale(0, RoundingMode.HALF_UP).intValue();
        
        wi = new WritableImage(width, height);
    }

}
