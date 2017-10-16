/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mckingbell;

/**
 *
 * @author casgu
 */
public class Car {
    private int startTime;
    public int waitTime;
    
    public int friesOrdered;
    public int burgersOrdered;
    
    public Car( int startTime ){
        this.startTime = startTime;
        
        this.friesOrdered = (int) (Math.random() * 11);
        this.burgersOrdered = (int) (Math.random() * 11);
    }
    
    
    public int getWaitTime() {
        return waitTime;
    }
    /**
     * 
     * @param waitTime where n is the current loop interval when the order is finished
     */
    public void setWaitTime( int waitTime ) {
        this.waitTime = waitTime;
    }

    public int getFriesOrdered() {
        return friesOrdered;
    }

    public int getBurgersOrdered() {
        return burgersOrdered;
    } 
}
