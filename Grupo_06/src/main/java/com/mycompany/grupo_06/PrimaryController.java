package com.mycompany.grupo_06;

import Modelos.Alerta;
import Modelos.Usuario;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
    
    static Usuario usuarioPrincipal;
    @FXML
    TextField tfUsuario;
    @FXML
    PasswordField tfClave;
    @FXML
    Button btIniciarSesion;
    @FXML
    Button btCrearCuenta;
    ArrayList<Usuario> listaUsuarios;
    @FXML
    VBox panel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaUsuarios=Usuario.leerListaSerializada();
        try(FileInputStream input=new FileInputStream("src/main/resources/source/imagenFondo.jpg")){
            Image image=new Image(input,751, 500,false,false);
             BackgroundImage bImg = new BackgroundImage(image,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundPosition.CENTER,
                                                   BackgroundSize.DEFAULT);
            Background bGround = new Background(bImg);
            panel.setBackground(bGround);
        }catch(IOException e){
            System.out.println("Archivo no encontrado");            
        }
        
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        if(ValidarUsuario()==true){ 
            App.setRoot("Bienvenida");
        }else{
            Alerta.errorIniciarSesion();
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
                usuarioPrincipal=u;
            }
        }
        return validar;
        
    }
    
    @FXML
    private void crearUsuario(ActionEvent event) {
        VBox root=new VBox();
        TextField nombre=new TextField();
        nombre.setPromptText("Nombre");
        TextField apellido=new TextField();
        apellido.setPromptText("Apellido");
        TextField usuario=new TextField();
        usuario.setPromptText("Usuario");
        TextField contra=new TextField();
        contra.setPromptText("Clave");
        Button crear=new Button("Crear cuenta");
        root.getChildren().addAll(nombre,apellido,usuario,contra,crear);
        root.setSpacing(25);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(false);
        root.setPrefSize(473, 372);
        App.scene.setRoot(root);
        
        crear.addEventHandler(ActionEvent.ACTION, (ActionEvent t) -> {
            if(nombre.getText().equals("") || apellido.getText().equals("")|| usuario.getText().equals("")|| contra.getText().equals("")){
                Alerta.hayAlgoVacio();
            } else {
                Usuario u=new Usuario(nombre.getText(),apellido.getText(),usuario.getText(),contra.getText());
                try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/files/Usuarios.txt",true))){
                    String cadena="\n"+nombre.getText()+","+apellido.getText()+","+usuario.getText()+","+contra.getText();
                    bw.write(cadena);
                    listaUsuarios.addLast(u);
                    Usuario.escribirLista(listaUsuarios);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                Alerta.creacionCuentaExitoso();
                App.scene.setRoot(panel);

            }
        });

    }
    
    public static Usuario devolverUsuario(){
        return usuarioPrincipal;
    }

    
}
