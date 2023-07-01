package com.mycompany.grupo_06;

import Modelos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import tdas.ArrayList;

public class PrimaryController implements Initializable{

    @FXML
    TextField tfUsuario;
    @FXML
    PasswordField tfClave;
    @FXML
    Button btIniciarSesion;
    @FXML
    Button btCrearCuenta;
    public ArrayList<Usuario> listaUsuarios=Usuario.CargarUsuarios();
    @FXML
    VBox panel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img = new Image("https://fondosmil.com/fondo/31886.jpg");
        BackgroundImage bImg = new BackgroundImage(img,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundPosition.CENTER,
                                                   BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        panel.setBackground(bGround);
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
          if(ValidarUsuario()==true){ 
            App.setRoot("secondary");

        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("Usuario o clave incorrectos");
            Optional<ButtonType> opciones = alerta.showAndWait();
            tfUsuario.clear();
            tfClave.clear();
        }
        
    }
    
    public boolean ValidarUsuario() {
        String usuario = tfUsuario.getText();
        String clave = tfClave.getText();
        boolean validar=false;
        for (int i=0;i<listaUsuarios.size();i++){
            Usuario u=listaUsuarios.get(i);
            if(u.getUsuario().equals(usuario) && u.getClave().equals(clave)){
                validar=true;
            }
        }
        System.out.println(validar);
        return validar;
        
    }

    
}
