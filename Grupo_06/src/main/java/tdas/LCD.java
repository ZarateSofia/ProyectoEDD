/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tdas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author USER
 */
public class LCD<E> implements List<E> {
    
    Node<E> last;

    public LCD() {
        this.last = null;
    }

    @Override
    public boolean addLast(E element) {
        if(element == null){
            return false;
        }
        
        Node<E> nodo = new Node(element);
        
        if(this.isEmpty()){
            last = nodo;
            last.setNext(nodo);
            last.setPrev(nodo);
        } else{
            Node<E> lastNode = last.getPrev();
            nodo.setNext(last);
            nodo.setPrev(lastNode);
            lastNode.setNext(nodo);
            last.setPrev(nodo);
            
        }
        
        return true;
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        int cont = 0;
        for(E nodo:this){
            cont++;
        }
        
        
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public E get(int index) {
        
        if(index<0 || isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        
        Node<E> node = last;
        for(int i=0; i<index;i++){
            node = node.getNext();
            if(node == last){
                throw new IndexOutOfBoundsException();
            }
        }
        
        return node.getContent();
    }
    
    @Override
    public String toString(){
        String mss = "";
        for(E nodo:this){
            mss+= " " + nodo +  ",";
        }
        
        return mss;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>(){
            Node<E> cursor = last;
            
            @Override
            public boolean hasNext() { 
                return cursor != null;
            }

            @Override
            public E next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                
                E e = cursor.getContent();
                cursor = cursor.getNext();
                if(cursor == last){
                    cursor = null;
                }
                
                return e;
            }
            
        };
        
        return it;
    }
    
}
