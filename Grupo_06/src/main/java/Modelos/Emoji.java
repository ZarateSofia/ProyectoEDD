/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import javafx.scene.image.ImageView;

/**
 *
 * @author USER
 */
public class Emoji {
    private final int id;
    private ImageView cuerpo;
    private ImageView ojos;
    private ImageView boca;

    public Emoji(ImageView cuerpo, ImageView ojos, ImageView boca, int id) {
        this.id = id;
        this.cuerpo = cuerpo;
        this.ojos = ojos;
        this.boca = boca;
    }

    public int getId() {
        return id;
    }

    public ImageView getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(ImageView cuerpo) {
        this.cuerpo = cuerpo;
    }

    public ImageView getOjos() {
        return ojos;
    }

    public void setOjos(ImageView ojos) {
        this.ojos = ojos;
    }

    public ImageView getBoca() {
        return boca;
    }

    public void setBoca(ImageView boca) {
        this.boca = boca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
    
}
