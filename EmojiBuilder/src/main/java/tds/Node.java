/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tds;

/**
 *
 * @author USER
 * @param <E>
 */
public class Node<E> {
    Node<E> previo;
    Node<E> siguiente;
    E content;

    public Node(E content) {
        this.content = content;
    }

    public Node<E> getPrevio() {
        return previo;
    }

    public void setPrevio(Node<E> previo) {
        this.previo = previo;
    }

    public Node<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node<E> siguiente) {
        this.siguiente = siguiente;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E contenido) {
        this.content = contenido;
    }
    
}
