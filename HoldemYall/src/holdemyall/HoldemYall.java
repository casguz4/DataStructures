/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdemyall;

import java.util.ArrayList;
import stacks.LinkedStack;
import java.util.Random;

/**
 *
 * @author etcharn1
 */
public class HoldemYall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<Card>();
        for ( int face = 2; face < Face.ACE; face++ )
        {
            deck.add( new Card( Suit.SPADES, face ) );
        }
        for ( int face = 2; face < Face.ACE; face++ )
        {
            deck.add( new Card( Suit.HEARTS, face ) );
        }
        for ( int face = 2; face < Face.ACE; face++ )
        {
            deck.add( new Card( Suit.CLUBS, face ) );
        }
        for ( int face = 2; face < Face.ACE; face++ )
        {
            deck.add( new Card( Suit.DIAMONDS, face ) );
        }
        
        for ( Card card : deck )
        {
            System.out.println(card.face + card.suit);
        }
        
        LinkedStack<Card> thisIsTheRealDeck = new LinkedStack<>();
        
        Random random = new Random();
        while ( !deck.isEmpty() )
        {
            thisIsTheRealDeck.push(
                    deck.remove( random.nextInt(deck.size())) );
        }
        
//        while ( !thisIsTheRealDeck.isEmpty() )
//        {
//            Card card = thisIsTheRealDeck.pop();
//            System.out.println(card.face + card.suit);
//        }
        Card[] hand = new Card[5];
        for ( int cardNumber = 0; cardNumber < hand.length; cardNumber++ )
        {
            hand[cardNumber] = thisIsTheRealDeck.pop();
        }
        PokerHand myHand = new PokerHand(hand);
    }   
}