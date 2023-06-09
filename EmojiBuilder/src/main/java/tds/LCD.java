/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tds;

import java.util.Iterator;

/**
 *
 * @author USER
 * @param <E>
 */
public class LCD<E> implements List<E> {
    
    Node<E> first;
    
    public LCD(){
        first = null;
    }

    @Override
    public void addFirst(E element) {
        if(element == null){
            return;
        }
        Node<E> nodo = new Node(element);
        if(this.isEmpty()){
            first = nodo;
            first.setPrevio(nodo);
            first.setSiguiente(nodo);
            
        }else{
            Node<E> last = first.getPrevio();
            nodo.setSiguiente(first);
            nodo.setPrevio(last);
            
            first.setPrevio(nodo);
            last.setSiguiente(nodo);
            
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
        int cont = 0;
        
        
        return cont;
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
        Iterator<E> it = new Iterator(){
            
            Node<E> cursor = first;
            @Override
            public boolean hasNext() {
                return cursor.getSiguiente() != first;
            }

            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getSiguiente();
                return e;
            }
            
        };
        
        return it;
    }
    
}
