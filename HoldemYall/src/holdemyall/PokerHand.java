/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdemyall;


import java.util.*;

/**
 *
 * @author etcharn1
 */
public class PokerHand implements Comparable<PokerHand>{
    
    
    public static final int STRAIGHT_FLUSH = 9;
    public static final int FOUR_OF_A_KIND = 8;
    public static final int FULL_HOUSE = 7;
    public static final int FLUSH = 6;
    public static final int STRAIGHT = 5;
    public static final int THREE_OF_A_KIND = 4;
    public static final int TWO_PAIR = 3;
    public static final int PAIR = 2;
    public static final int HIGH_CARD = 1;
    
    int occurenceCount = 0;
    
    
    private Card[] cards;
    
    public PokerHand(Card[] cards)
    {
        this.cards = cards;
        Arrays.sort(this.cards);
    }

    @Override
    public int compareTo(PokerHand o) {
        if ( getHandRank() == o.getHandRank() )
        {
            // tiebreak
        }
        return getHandRank() - o.getHandRank();
    }
    
    private boolean isStraightFlush()
    {
        return isFlush() && isStraight();
    }
    
    public int getHandRank()
    {
        if( isStraightFlush() ){
            return STRAIGHT_FLUSH;
        }
        
        if( isFourKind() ){
            return FOUR_OF_A_KIND;
        }
        
        if( isFullHouse() ){
            return FULL_HOUSE;
        }
        
        if( isThreeKind() ){
            return THREE_OF_A_KIND;
        }
        
        if( isTwoPair() ){
            return TWO_PAIR;
        }
        
        //all else fails
        return HIGH_CARD;
    }

    public boolean isFlush() {
        return cards[0].suit == cards[1].suit && cards[0].suit == cards[2].suit && cards[0].suit == cards[3].suit && cards[0].suit == cards[4].suit ;
    }

    public boolean isStraight() {
        return cards[0].face == cards[1].face - 1 && cards[1].face == cards[2].face - 1 && cards[2].face == cards[3].face - 1 && cards[3].face == cards[4].face - 1;
    }
    
    //fix this i guess. somehow use recursion
    public boolean isFourKind(){
        return getOccurence(0, cards.length, 0, occurenceCount) == 4;
    }
    
    public boolean isFullHouse(){
        
    }
    
    public boolean isThreeKind(){
        return getOccurence(0, cards.length, 0, occurenceCount) == 3;
    }
    
    public boolean isTwoPair(){
       
    }
    
    public boolean isPair(){
        return getOccurence(0, cards.length, 1, occurenceCount) <= 2;
    }
    
    public int getOccurence(int start, int end, int n, int count){
        if(count == 4){
            return count;
        }else if(cards[n].face == cards[start].face){
            getOccurence(start, end, n+1, count+1);
        }else if(cards[n].face != cards[start].face){
            getOccurence(start+1, end, n, count);
        }else if(cards[n].face == cards[end].face){
            return count;
        }
        
        return count;
    }
}
