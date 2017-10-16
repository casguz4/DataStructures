/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclassexample3;

import java.util.Stack;

/**
 *
 * @author etcharn1
 */
public class InClassExample3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       ReallyBigInteger bigNumber = new ReallyBigInteger();
       
       for(int number = 1; number < 1000; number++){
           bigNumber.addDigit(number % 10);
       }
       
        System.out.println( bigNumber.toString() );
    }
    
    public static void First()
    {
        Second(5);
    }
    
    public static void Second(int i)
    {
        Third( i % 5 );
    }
    
    public static void Third(int x)
    {
        System.out.print(10/x);
    }
}
