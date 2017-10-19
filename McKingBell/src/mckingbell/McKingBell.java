/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mckingbell;

import stack.LinkedStack;
import queue.LinkedDequeue;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author casgu
 */
public class McKingBell {
    public static void main(String[] args) {
        int burgersToMake,
            friesToMake;
        
        ArrayList<Integer> waitTimeList = new ArrayList<>();
        ArrayList<Integer> burgersThrownOut = new ArrayList<>();
        ArrayList<Integer> numberOfDriveOffs = new ArrayList<>();
        
        //prepare the food for lunch rush
        LinkedStack<Integer> fries = new LinkedStack<>();
        LinkedDequeue<Burger> burgers = new LinkedDequeue<>();
        
        makeSomeFries(5, fries);
//        makeSomeBurgers(5, 0, burgers);
          
//this is meant to test whats being added        
        
//
        for( int minutes = 0; minutes < 5; minutes++ ){
            burgersToMake = 0;
            friesToMake = 0;
            
            Random random = new Random();
            int newCar = random.nextInt(3)+1;
            
            //create new car
            if( newCar == 3 ){
                Car carInLine = new Car( minutes );
            }
           
            if( getBurgerDequeSize( burgers ) < 5 ){
                burgersToMake = 5 - getBurgerDequeSize( burgers );
                makeSomeBurgers( burgersToMake, minutes, burgers );
            }
            
            if( getFrieStackSize( fries ) < 5 ){
                friesToMake = 5 - getFrieStackSize( fries );
                makeSomeFries( friesToMake, fries );
            }
            
            
        }
        while(!fries.isEmpty()){
            System.out.println( fries.pop() );
        }
    }
    
    //SpongeBob duties
    private static void makeSomeFries( int numFriesToMake, LinkedStack<Integer> fries ){
        //make fries
        for(int makeFries = 1; makeFries <= numFriesToMake; makeFries++){
            fries.push(makeFries);
        }
    }//end makeSomeFries
    
    private static void makeSomeBurgers( int numBurgersToMake, int time, LinkedDequeue<Burger> burgers ){
        //make burgers
        for(int makeBurgers = 1; makeBurgers <= numBurgersToMake; makeBurgers++){
            Burger burger = new Burger(time);
            burgers.addToBack(burger);
        }
    }//end makeSomeBurgers
    
    private static int getBurgerDequeSize( LinkedDequeue<Burger> burgers ){
        int countBurgers = 0;
        
        if( burgers.isEmpty() ){
            return countBurgers;
        }
        
        while( !burgers.isEmpty() ){
            countBurgers++;
        }
        
        return countBurgers;
    }//end getBurgerDequeSize
    
    private static int getFrieStackSize( LinkedStack<Integer> fries ){
        
        return fries.isEmpty() ?  0 : fries.getSize();
        
    }//end getFriesStackSize
}
