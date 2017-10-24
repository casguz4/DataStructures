/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author etcharn1
 */
public interface StackInterface<T> {
    T pop() ;
    T peek() ;
    void push(T item);
    boolean isEmpty();
    void clear();
    int getSize();
}
