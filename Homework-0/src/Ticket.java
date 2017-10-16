
public class Ticket {
    private int[] whiteBalls = new int[5];
    private int powerball, iterator;
        
    public Ticket(){
        for(int i = 0; i < whiteBalls.length; i++){
            this.whiteBalls[i] = (int)(Math.random() * 69 + 1);
        }
        this.powerball = (int)(Math.random() * 26 + 1);
    }//end ctor
    
    public void printTicket(){
        System.out.println(whiteBalls[0] + " " + whiteBalls[1] + " " + whiteBalls[2] + " " + whiteBalls[3] + " "
        + whiteBalls[4] + " " + powerball);
    }//end print ticket
    
    //get balls
    public int[] getWhiteBalls(){
        return whiteBalls;
    }
    public int getPowerball(){
        return powerball;
    }
}//end Ticket class
