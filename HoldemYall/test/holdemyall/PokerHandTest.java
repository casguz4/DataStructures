/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdemyall;

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
public class PokerHandTest {
    
    public PokerHandTest() {
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
    public void testIsFlush() {
        Card[] cards = { new Card(Suit.CLUBS, Face.TWO), 
            new Card(Suit.CLUBS, Face.FOUR),
            new Card(Suit.CLUBS, Face.SIX),
            new Card(Suit.CLUBS, Face.EIGHT),
            new Card(Suit.CLUBS, Face.TEN)
        };
        PokerHand hand = new PokerHand(cards);
        
        assertTrue(hand.isFlush());
    }
    
    @Test
    public void testIsStraight() {
        Card[] cards = { new Card(Suit.CLUBS, Face.TWO), 
            new Card(Suit.CLUBS, Face.SIX),
            new Card(Suit.CLUBS, Face.FOUR),
            new Card(Suit.CLUBS, Face.FIVE),
            new Card(Suit.CLUBS, Face.THREE)
        };
        PokerHand hand = new PokerHand(cards);
        
        assertTrue(hand.isStraight());
    }
}
