/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author etcharn1
 */
public class LinkedStackTest {
    
    public LinkedStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPop() {
        System.out.println("pop");
        LinkedStack<Integer> instance = new LinkedStack<Integer> ();
        Integer expResult = 42;
        instance.push(expResult);
        Integer result = instance.pop();
        assertEquals(expResult, result);
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testPeek() {
        System.out.println("peek");
        LinkedStack<Integer> instance = new LinkedStack<Integer> ();
        Integer expResult = 42;
        instance.push(expResult);
        Integer result = instance.peek();
        assertEquals(expResult, result);
    }

    @Test
    public void testPush() {
        System.out.println("push");
        Integer item = 42;
        LinkedStack<Integer> instance = new LinkedStack<Integer>();
        assertTrue(instance.isEmpty());
        instance.push(item);
        assertFalse(instance.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedStack instance = new LinkedStack();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testClear() {
        System.out.println("clear");
        LinkedStack instance = new LinkedStack();
        instance.clear();
        assertTrue(instance.isEmpty());
    }
    
}
