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

    public Emoji() {
        this.id = 2;
        this.cuerpo = new ImageView();
        this.ojos = new ImageView();
        this.boca = new ImageView();
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
    
    public void settearPartes(ImageView img, int parte){
        ImageView nimg = new ImageView();
        switch (parte) {
            case 1:
                nimg.setImage(img.getImage());
                setCuerpo(nimg);
                cuerpo.setFitWidth(90);
                cuerpo.setFitHeight(90);
                cuerpo.setSmooth(true);
                break;
            case 2:
                nimg.setImage(img.getImage());
                setBoca(nimg);
                boca.setSmooth(true);
                break;
            default:
                nimg.setImage(img.getImage());
                setOjos(nimg);
                ojos.setFitWidth(70);
                ojos.setFitHeight(70);
                ojos.setSmooth(true);
                break;
        }
    }
    
}
