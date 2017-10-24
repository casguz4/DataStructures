/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mckingbell;

import stack.LinkedStack;
import queue.LinkedDequeue;
import java.util.Random;

/**
 *
 * @author casgu
 */
public class McKingBell {
    public static void main(String[] args) {
        int burgersToMake,
            friesToMake,
            newCar;
        
        int numberOfCarsServed = 0;
        int maxWaitTime = 0;
        int burgersThrownOut = 0;
        int numberOfDriveOffs = 0;
        
        double avgWaitTime = 0;
        
        //prepare the food for lunch rush
        LinkedStack<Integer> fries = new LinkedStack<>();
        LinkedDequeue<Burger> burgers = new LinkedDequeue<>();
        LinkedDequeue<Car> driveThruLine = new LinkedDequeue<>();
        
        Random random = new Random();
        
        makeSomeFries(5, fries);
        makeSomeBurgers(5, 0, burgers);
          
//this is meant to test whats being added        
//        while(!fries.isEmpty()){
//            System.out.println( fries.pop() );
//        }
//
        for( int minutes = 0; minutes < 120; minutes++ ){
            burgersToMake = 0;
            friesToMake = 0;
           
            //check how many burgers to make
            if( getBurgerDequeSize( burgers ) < 5 ){
                burgersToMake = 5 - getBurgerDequeSize( burgers );
                makeSomeBurgers( burgersToMake, minutes, burgers );
            }
            
            //check fries to make
            if( getFryStackSize( fries ) < 5 ){
                friesToMake = 5 - getFryStackSize( fries );
                makeSomeFries( friesToMake, fries );
            }
           
            
            if( driveThruLine.getSize() > 5){
                if( minutes - driveThruLine.getBack().waitTime > 1){
                    driveThruLine.removeBack();
                    numberOfDriveOffs++;
                }
            }
            
            newCar = random.nextInt(3)+1;//1 in 3 chance
            //create new car
            if( newCar == 3 ){
                Car newCarInLine = new Car( minutes );
                driveThruLine.addToBack( newCarInLine );
            }
            
            //serve burgers
            while( !burgers.isEmpty() || driveThruLine.getFront().burgersOrdered > 0 ){
                if( !burgerIsTooOld( minutes, burgers ) ){
                    burgers.removeBack();
                    driveThruLine.getFront().burgersOrdered--;
                }else{
                    burgers.removeBack();
                }
            }
            
            //serve fries
            while( !fries.isEmpty() || driveThruLine.getFront().friesOrdered > 0 ){
                fries.pop();
                driveThruLine.getFront().friesOrdered--;
            }
            
            //if no more burgers or fries to give to front car in line
            if( driveThruLine.getFront().friesOrdered == 0 && driveThruLine.getFront().burgersOrdered == 0 ){
                avgWaitTime += driveThruLine.getFront().waitTime;
                if( driveThruLine.getFront().waitTime > maxWaitTime ){
                    maxWaitTime = driveThruLine.getFront().waitTime;
                }
                burgers.removeFront();
                numberOfCarsServed++;
            }
        }//end for loop and minutes
        
        avgWaitTime = avgWaitTime / numberOfCarsServed;
        
        System.out.println("Total number of customers served was: " + numberOfCarsServed);
        System.out.println("The average wait time per customer was: " + avgWaitTime);
        System.out.println("The longest wait was: " + maxWaitTime);
        System.out.println("The total number of drive offs was: " + numberOfDriveOffs);
        
        System.out.println("");
        System.out.println("Not bad....but we could do better.");
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
        
        return burgers.isEmpty() ? 0 : burgers.getSize();
    }//end getBurgerDequeSize
    
    private static int getFryStackSize( LinkedStack<Integer> fries ){
        
        return fries.isEmpty() ?  0 : fries.getSize();
        
    }//end getFriesStackSize
    
    //Squidward duties

    private static boolean burgerIsTooOld( int minutes, LinkedDequeue<Burger> burgers ) {
        return minutes - burgers.getBack().lifeTime > 10;
    }
    
}
