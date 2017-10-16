
package queue;

/**
 *
 * @author casgu
 * @param <T>
 */
public class LinkedDequeue<T>{
   
        private Node<T> first;
        private Node<T> last;
        
        public <T> LinkedDequeue(){
            first = null;
            last = null;
        }
   
        public void addToFront(T item){
            Node newNode = new Node(null, item, first);
            
            if( first == null ){
                last = newNode;
            }else{
                first.previous = newNode;
            }
            
            first = newNode;
        }
        
        public void addToBack(T item){
            Node newNode = new Node(last, item, null);
            
            if( last == null ){
                first = newNode;
            }else{
                last.next = newNode;
            }
            
            last = newNode;
        }
        
        public T getFront(){
            if( first == null ){
                return null;
            }
            
            return first.data;
        }
        
        public T getBack(){
            if( last == null ){
                return null;
            }
            
            return last.data;
        }
        
        public T removeFront(){
            T item = getFront();
            
            first = first.next;
            
            if( first != null ){
                first.previous = null;
            }else{
                last = null;
            }
            
            return item;
        }
        
        public T removeBack(){
            T item = getBack();
            
            last = last.next;
            
            if( last != null ){
                last.previous = null;
            }else{
                first = null;
            }
            
            return item;
        }
        
        public boolean isEmpty(){
            return first == null && last == null;
        }
        
    private class Node<T>{
        
        public T data; 
        public Node previous;
        public Node next;
        
        public Node( Node previous, T data, Node next){
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
        
    }
}
