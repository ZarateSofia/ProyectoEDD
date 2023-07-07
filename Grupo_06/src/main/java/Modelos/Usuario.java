/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    
    public void agregarEmoji(Emoji em){
        listaEmojis.addLast(em);
    }
    
    @Override
    public String toString() {
        return usuario+","+clave+","+listaEmojis;
    }
    
    
    public static ArrayList<Usuario> leerListaSerializada() {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        try(ObjectInputStream objinput=new ObjectInputStream(new FileInputStream("usuarios.ser"));){
            listaUsuarios=(ArrayList<Usuario>)objinput.readObject();
            System.out.println(listaUsuarios);
        }catch (FileNotFoundException ex1) {
            System.out.println("No se encontro el archivo");
        }catch (IOException ex2) {
            ex2.printStackTrace();
        }catch (ClassNotFoundException ex3) {
            ex3.printStackTrace();
        }
        return listaUsuarios;
    
    }
    
    public static void escribirLista(ArrayList<Usuario> lista){
        try{
            FileOutputStream fos = new FileOutputStream("usuarios.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.flush();
            oos.close();
            fos.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
