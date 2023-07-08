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
    
    private Node<E> last;

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

        int contador = 0;
        while(contador != index){
            node = node.getNext();
            contador++;
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
    
    public E getNextElement(int index){
        Node<E> node = last;
        for(int i=0; i<index;i++){
            node = node.getNext();
        }
        return node.getNext().getContent();
    }
    
    public E getPrevElement(int index){
        Node<E> node = last;
        for(int i=0; i<index;i++){
            node = node.getNext();
        }
        return node.getPrev().getContent();
    }
    
    public E getPrevTooElement(int index){
        Node<E> node = last;
        for(int i=0; i<index;i++){
            node = node.getNext();
        }
        node = node.getPrev();
        return node.getPrev().getContent();
    }
    
    public E getNextTooElement(int index){
        Node<E> node = last;
        for(int i=0; i<index;i++){
            node = node.getNext();
        }
        node = node.getNext();
        return node.getNext().getContent();
    }
    
    //Arreglar este algortimo
    @Override
    public E remove(int index) {
        
        if(isEmpty()){
            return null;
        }
        
        E elemento;
        
        if(index == 0){
            if(last.getNext() == null){
                elemento = last.getContent();
                last = null;
            }else{
                Node<E> lastNode = last.getPrev();
                Node<E> nextNode = last.getNext();
                
                elemento = last.getContent();
                nextNode.setPrev(lastNode);
                lastNode.setNext(nextNode);
                last = nextNode;
            }
        } else if(index > 0){
            Node<E> nodoEliminar = last;
            int cont = 0;
            while(cont < index){
                nodoEliminar = nodoEliminar.getNext();
                cont++;
                if(nodoEliminar == last){
                    return null; //Indice Invalido
                }
            }
           
            elemento = nodoEliminar.getContent();
            Node<E> lastNode = nodoEliminar.getPrev();
            Node<E> nextNode = nodoEliminar.getNext();
            
            lastNode.setNext(nextNode);
            nextNode.setPrev(lastNode);
            nodoEliminar = nextNode;
            
        } else{
            elemento = null;
        }
        
        
        return elemento;
    }
    
    public int indexOf(E element){
        int i = 0;
        Node<E> node = last;
        for(E e: this){
            if(e.equals(node.getContent())){
                return i;
                
            }
            i++;
        }
        
        return i;
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
