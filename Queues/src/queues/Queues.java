/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;

/**
 *
 * @author casgu
 */
public class Queues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       LinkedDequeue dequeue = new LinkedDequeue<Integer>();
       
       dequeue.addToFront(10);
       dequeue.addToBack(20);
       dequeue.addToBack(30);
       
       while( !dequeue.isEmpty() ){
           System.out.println( dequeue.removeFront() );
       }
       
    }
}
