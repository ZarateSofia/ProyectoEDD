/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import tdas.ArrayList;

/**
 *
 * @author DELL
 */
public class Usuario implements Serializable{
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private ArrayList<Emoji> listaEmojis;

    public Usuario(String nombre, String apellido,String usuario, String clave) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.listaEmojis=new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Emoji> getListaEmojis() {
        return listaEmojis;
    }

    public void setListaEmojis(ArrayList<Emoji> listaEmojis) {
        this.listaEmojis = listaEmojis;
    }
    

    @Override
    public String toString() {
        return usuario+","+clave+","+listaEmojis;
    }
//
    public static ArrayList<Usuario> CargarUsuarios(){
        ArrayList<Usuario> listaUsuarios=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader("src/main/resources/files/Usuarios.txt"))){
        String linea= bf.readLine();
            while(linea!=null){
                String datos[]=linea.strip().split(",");
                Usuario u=new Usuario(datos[0],datos[1],datos[2],datos[3]);
                listaUsuarios.addLast(u);
                linea=bf.readLine();
            }
        }catch(IOException e){
            System.out.println("Archivo no encontrado");
        }
        System.out.println(listaUsuarios);
        return listaUsuarios;   
    }
    
    
//    public static ArrayList<Usuario> leerListaSerializada() {
//        ArrayList<Usuario> listaUsuarios=null;
//        try(ObjectInputStream objinput=new ObjectInputStream(new FileInputStream("src/main/resources/files/ListaSerializada"));){
//            listaUsuarios=(ArrayList<Usuario>)objinput.readObject();
////            System.out.println(listaUsuarios);
//        }catch (FileNotFoundException ex1) {
//            System.out.println("No se encontro el archivo");
//        }catch (IOException ex2) {
//            ex2.printStackTrace();
//        }catch (ClassNotFoundException ex3) {
//            ex3.printStackTrace();
//        }
//        return listaUsuarios;
//    
//    }
}
