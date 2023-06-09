/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tdas;

import java.util.Iterator;

/**
 *
 * @author USER
 */
public class LCD<E> implements List<E> {
    
    Node<E> first;

    public LCD() {
        this.first = null;
    }
    
    

    @Override
    public void addFirst(E element) {
        if(element == null){
            return;
        }
        Node<E> nodo = new Node(element);
        
        if(this.isEmpty()){
            first = nodo;
            first.setNext(nodo);
            first.setPrev(nodo);
        }else{
            Node<E> last = first.getPrev();
            nodo.setNext(first);
            nodo.setPrev(last);
            
            first.setPrev(nodo);
            last.setNext(nodo);
            
            first = nodo;
        }
    }

    @Override
    public void addLast(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
