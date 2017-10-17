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
        
        ArrayList<Integer> waitTimeList = new ArrayList<>();
        ArrayList<Integer> burgersThrownOut = new ArrayList<>();
        ArrayList<Integer> numberOfDriveOffs = new ArrayList<>();
        
        //prepare the food for lunch rush
        LinkedStack<Integer> fries = new LinkedStack<>();
        LinkedDequeue<Burger> burgers = new LinkedDequeue<>();
        
            makeSomeFries(5, fries);
            makeSomeBurgers(5, 0, burgers);
          
//this is meant to test whats being added        
//        while(!burgers.isEmpty()){
//            System.out.println(burgers.removeFront().lifeTime);
//        }
//
        for( int minutes = 0; minutes < 120; minutes++ ){
            Random random = new Random();
            int newCar = random.nextInt(3)+1;
            
            //create new car
            if( newCar == 3 ){
                Car carInLine = new Car( minutes );
            }
        }
        
    }
    
    //SpongeBob duties
    private static void makeSomeFries( int numFriesToMake, LinkedStack<Integer> fries ){
        //make fries
        for(int makeFries = 1; makeFries <= numFriesToMake; makeFries++){
            fries.push(makeFries);
        }
    }
    
    private static void makeSomeBurgers( int numBurgersToMake, int time, LinkedDequeue<Burger> burgers ){
        //make burgers
        for(int makeBurgers = 1; makeBurgers <= numBurgersToMake; makeBurgers++){
            Burger burger = new Burger(time);
            burgers.addToBack(burger);
        }
    }
    
}
