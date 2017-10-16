package linkedbag;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author casgu
 */
public class LinkedBag <T> implements BagInterface<T>{
    private Node first;
    private int currentSize;
    
    public LinkedBag(){
        first = null;
        currentSize = 0;
    }
    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public boolean add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T item) {
        Node newNode = new Node(item);
        newNode.next = first;
        first = newNode;
        currentSize++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public T remove() {
        T result = null;
        if(first != null){
            result = first.data;
            first = first.next;
            currentSize--;
        }
        return result;
    }
    
    private Node getReferenceTo(T item){
        boolean found = false;
        Node currentNode = first;
        
        while(!found && currentNode != null){
            if(item.equals(currentNode.data)){
                found = true;
            }else{
                currentNode = currentNode.next;
            }//end if item equals currentNode.data
        }//end while
        
        return currentNode;
    }//end getReferenceTo
    
    @Override
    public boolean remove(T item) {
        boolean result = false;
        Node itemNode = getReferenceTo(item);
        if(itemNode != null){
            itemNode.data = first.data;
            first = first.next;
            currentSize--;
            result = true;
        }//end if itemNode = null
        
        return result;
    }//end remove

    @Override
    public int getFrequencyOf(T item) {
        int frequency = 0;
        Node currentNode = first;
        
        while(currentNode != null){
            if(item.equals(currentNode.data)){
                frequency++;
            }//end if
            
            currentNode = currentNode.next;
        }//end while
        return frequency;
    }//end getFrequencyOf

    @Override
    public boolean contains(T item) {
        boolean found = false;
        Node currentNode = first;
        
        while(!found && currentNode != null){
            if(item.equals(currentNode.data)){
                found = true;
            }//end if
            
            currentNode = currentNode.next;
        }//end while
        return found;
    }//end contains

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//end toArray
    
    
    private class Node{
        private T data;
        private Node next;
        
        Node(T data){
           this(data, null);
        }
        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }//end class Node
    
}//end class LinkedBag
