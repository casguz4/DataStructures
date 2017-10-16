/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingexamples;
 import java.util.Comparator;
/**
 *
 * @author casgu
 */
public class StringLengthSort implements Comparator<String>{

    @Override
    public int compare(String thing1, String thing2) {
        int lengthDifference = thing1.length() - thing2.length();
        
        if( lengthDifference != 0 ){
            return lengthDifference;
        }else{
            return thing1.compareTo(thing2);
        }
    }
}
