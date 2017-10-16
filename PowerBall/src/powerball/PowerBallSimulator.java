package powerball;

import javax.swing.JOptionPane;

/**
 *
 * @author Cas Guzdziol, modifying original work by Eric Chernosky
 * 
 * Though this says PowerBallSimulator, it is really the Mega Millions Simulator
 * I didn't want to have to go and change all the name. the 5 whites and 1 red 
 * is the exact same format. 
 */

public class PowerBallSimulator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int totalSpent = 0;
        int totalWon = 0;
        
        int numberOfTicketsToPurchase = Integer.parseInt(
                JOptionPane.showInputDialog(
                "Please enter the number of tickets you want to buy, or 0 to quit") );
        
        
        
        while ( numberOfTicketsToPurchase != 0 )
        {
            int i = 0;
            while(i < 3){
                switch(i){
                    case 0:
                        long startTime = System.nanoTime();
            
                        totalSpent += numberOfTicketsToPurchase * PowerBall.TICKET_PRICE;
                        PowerBall winningTicket = new PowerBall();

                        for ( int ticketNumber = 0; ticketNumber < numberOfTicketsToPurchase; ticketNumber++ )
                        {
                            PowerBall myTicket = new PowerBall();
                            totalWon += myTicket.getWinnings( winningTicket );
                            if ( myTicket.getWinnings(winningTicket ) == 1000000000 )
                            {
                                JOptionPane.showMessageDialog(null, "JACKPOT");
                            }
                        }

                        long endTime = System.nanoTime();

                        double totalTime = (endTime - startTime) / 100000000.0;

                        String message = String.format("Total Spent: %d - Total Won: %d - Net Loss: %d", 
                                totalSpent, totalWon, totalWon - totalSpent );
                        JOptionPane.showMessageDialog(null, message);
                        JOptionPane.showMessageDialog(null, String.format("Total Time for PowerBall(): %f", totalTime));
                        i++;
                        break;
                    
                    case 1:
                        startTime = System.nanoTime();
            
                        totalSpent += numberOfTicketsToPurchase * PowerBallArrayBag.TICKET_PRICE;
                        PowerBallArrayBag winningTicketArraybag = new PowerBallArrayBag();

                        for ( int ticketNumber = 0; ticketNumber < numberOfTicketsToPurchase; ticketNumber++ )
                        {
                            PowerBallArrayBag myTicket = new PowerBallArrayBag();
                            totalWon += myTicket.getWinnings( winningTicketArraybag );
                            if ( myTicket.getWinnings(winningTicketArraybag ) == 1000000000 )
                            {
                                JOptionPane.showMessageDialog(null, "JACKPOT");
                            }
                        }

                        endTime = System.nanoTime();

                        totalTime = (endTime - startTime) / 100000000.0;

                        message = String.format("Total Spent: %d - Total Won: %d - Net Loss: %d", 
                                totalSpent, totalWon, totalWon - totalSpent );
                        JOptionPane.showMessageDialog(null, message);
                        JOptionPane.showMessageDialog(null, String.format("Total Time PowerBallArrayBag(): %f", totalTime));
                        i++;
                        break;
                        
                    case 2:
                        startTime = System.nanoTime();
            
                        totalSpent += numberOfTicketsToPurchase * PowerBallLinkedBag.TICKET_PRICE;
                        PowerBallLinkedBag winningTicketLinked = new PowerBallLinkedBag();

                        for ( int ticketNumber = 0; ticketNumber < numberOfTicketsToPurchase; ticketNumber++ )
                        {
                            PowerBallLinkedBag myTicket = new PowerBallLinkedBag();
                            totalWon += myTicket.getWinnings( winningTicketLinked );
                            if ( myTicket.getWinnings(winningTicketLinked ) == 1000000000 )
                            {
                                JOptionPane.showMessageDialog(null, "JACKPOT");
                            }
                        }

                        endTime = System.nanoTime();

                        totalTime = (endTime - startTime) / 100000000.0;

                        message = String.format("Total Spent: %d - Total Won: %d - Net Loss: %d", 
                                totalSpent, totalWon, totalWon - totalSpent );
                        JOptionPane.showMessageDialog(null, message);
                        JOptionPane.showMessageDialog(null, String.format("Total Time PowerBallLinkedBag: %f", totalTime));
                        
                        i++;
                        break;
                    
                    default:
                        
                        break;
                }//end switch
            }//end while
            
            
            //ask to buy tickets again
            numberOfTicketsToPurchase = Integer.parseInt(
                JOptionPane.showInputDialog(
                "Please enter the number of tickets you want to buy, or 0 to quit") );
        }
    }
}
