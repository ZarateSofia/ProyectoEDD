/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tds;

/**
 *
 * @author USER
 */
public interface List<E> extends Iterable<E>{
    void addFirst(E element);
    void addLast(E element);
    void add(int index, E element);
    int size();
    boolean isEmpty();
    E get(int index);
}
