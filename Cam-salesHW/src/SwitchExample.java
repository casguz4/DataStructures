//@author:Cameron Guzdziol
//@Date: Oct 5th 2017
//@CIS 1500 1 - 5 pm
//using the scanner method we're using the Switch Statement

import java.util.Scanner;

public class SwitchExample
{
   public static void main(String[] args)
   {
      int num;
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Please enter any numbers between 1 to 3");
      num = keyboard.nextInt();
      
      switch(num)
      {
         case 1:
                  System.out.println("You've entered 1!");
                  break;
         case 2:
                  System.out.println("You've entered 2!");
                  break;
         case 3:  
                  System.out.println("You've entered 3!");
                  break;
         case 4:
                  System.out.println("You've entered 4!");
                  break;
      }
   }
}