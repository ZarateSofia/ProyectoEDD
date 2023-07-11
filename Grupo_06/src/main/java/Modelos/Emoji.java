/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;
import java.util.UUID;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author USER
 */
public class Emoji implements Serializable{
    private final UUID id;
    private String cuerpo;
    private String ojos;
    private String boca;
    
    public Emoji() {
        this.id = UUID.randomUUID();
        this.cuerpo = "";
        this.ojos = "";
        this.boca = "";
    }

    public UUID getId() {
        return id;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getBoca() {
        return boca;
    }

    public void setBoca(String boca) {
        this.boca = boca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
        return "Emoji{" + "id=" + id + '}';
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emoji other = (Emoji) obj;
        return this.id == other.id;
    }
    
    public void settearPartes(String img, int parte){
        switch (parte) {
            case 1:
                setCuerpo(img);
                break;
            case 2:
                setBoca(img);
                break;
            default:
                setOjos(img);
                break;
        }
    }
    
    public ImageView setImageCuerpo(){
        ImageView img = new ImageView();
        if(!cuerpo.equals("")){
            Image imagen = new Image(cuerpo);
            img.setImage(imagen);
            img.setFitWidth(110);
            img.setFitHeight(110);
        }
        
        return img;
    }
    
    public ImageView setImageOjos(){
        ImageView img = new ImageView();
        
        if(!ojos.equals("")){
            Image imagen = new Image(ojos);
            img.setImage(imagen);
            img.setFitWidth(70);
            img.setFitHeight(70);
            return img;
        }
        return img;
    }
    
    public ImageView setImageBoca(){
        ImageView img = new ImageView();
        
        if(!boca.equals("")){
            Image imagen = new Image(boca);
            img.setImage(imagen);
            img.setFitWidth(50);
            img.setFitHeight(50);
            return img;
        }
        return img;
    }
}
