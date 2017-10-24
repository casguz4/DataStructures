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
public class LinkedStack<T> implements StackInterface<T> {

    private Node firstItem;
    private int numberOfItems;
    
    public LinkedStack()
    {
        firstItem = null;
    }
    
    @Override
    public T pop() {
        T item = peek();
        firstItem = firstItem.next;
        numberOfItems--;
        return item;
    }

    @Override
    public T peek() {
        return firstItem.data;
    }

    @Override
    public void push(T item) {
        Node newNode = new Node(item, firstItem);
        firstItem = newNode;
        numberOfItems++;
    }

    @Override
    public boolean isEmpty() {
        return firstItem == null;
    }

    @Override
    public void clear() {
        firstItem = null;
        numberOfItems = 0;
    }
    
    @Override
    public int getSize(){
        return numberOfItems;
    }
    
    private class Node
    {
        private T data;
        private Node next;
        
        Node(T data)
        {
            this(data, null);
        }
        Node( T data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
}
