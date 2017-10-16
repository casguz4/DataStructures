import java.util.*;

import ArrayBag.ArrayBag;
import linkedbag.LinkedBag;

/**
 *
 * @author casgu
 */
public class PowerBall {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String input;
        int numTickets;
        int ballsMatched = 0;
        final int GRAND_PRIZE = 83000000;
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        double amountWon = 0;
        boolean powerball = false;
        Winner ticket = new Winner();
        
        //start loop
        do{
            long startTime = System.nanoTime();
            System.out.println("How many Power Ball tickets would you like to buy?");
            input = keyboard.nextLine();
            numTickets = Integer.parseInt(input);
            
            if(numTickets > 0){
                for(int i = 0; i <= numTickets; i++){
                tickets.add(new Ticket());
            }
            
            for(int i = 0; i < tickets.size(); i++){
                Ticket t = tickets.get(i);
                checkWhites(t, ticket, ballsMatched);
                
                if(checkRed(t, ticket) && ballsMatched == 5){
                    amountWon += GRAND_PRIZE;
                }else if(!checkRed(t, ticket) && ballsMatched == 5){
                    amountWon += 1000000;
                }else if(checkRed(t, ticket) && ballsMatched == 4){
                    amountWon += 50000;
                }else if(!checkRed(t, ticket) && ballsMatched == 4){
                    amountWon += 100;
                }else if(checkRed(t, ticket) && ballsMatched == 3){
                    amountWon += 100;
                }else if(!checkRed(t, ticket) && ballsMatched == 3){
                    amountWon += 7;
                }else if(checkRed(t, ticket) && ballsMatched == 2){
                    amountWon += 7;
                }else if(checkRed(t, ticket) && ballsMatched == 1){
                    amountWon += 4;
                }else if(checkRed(t, ticket) && ballsMatched == 0){
                    amountWon += 4;
                }//end else if
                    
            }//end for loop
            
            
            totalSpent(numTickets);
            System.out.println("You won a total of $" + amountWon);
            System.out.println("");
            long endTime = System.nanoTime();
            double totalTime = (endTime - startTime)/ 1000000000.0 ;
            System.out.println("Total time spent: " + totalTime);
            }
            
        }while(numTickets != 0);
        
    }
        
    public static void totalSpent(int numTickets){
        System.out.println("You spent a total of $" + (numTickets * 2) + " on tickets");
    }
    
    public static void checkWhites(Ticket t, Winner ticket, int ballsMatched){
        Ticket myTicket = t;
        Winner winner = ticket;

        int[] ticketWhites = myTicket.getWhiteBalls();
        int[] winnerWhites = winner.getWhiteBalls();
        ballsMatched = 0;
        
        for(int i = 0; i < 5; i++ ){
            for(int j = 0; j < 5; j++){
                if(ticketWhites[i] == winnerWhites[j]){
                    ballsMatched++;
                }//end if ticket bought whites = winning ticket whites
            }//end for j
        }//end for i
        
        if(checkRed(myTicket, winner)){
            
        }
    }//end checkWhites method
    
    public static boolean checkRed(Ticket t, Winner ticket){
        Ticket myTicket = t;
        Winner winner = ticket;
        int ticketRed = myTicket.getPowerball();
        int winnerRed = winner.getPowerball();
        
        if(ticketRed == winnerRed){
            return true;
        }else{
            return false;
        }
    }
}


