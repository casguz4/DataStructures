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
public class Burger {
    public int lifeTime;
    public Burger( int startTime ){
        this.lifeTime = startTime;
    }
    
    public int getBurgerShelfLife(){
        return lifeTime;
    }
}
