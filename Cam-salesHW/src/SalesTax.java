/**
@ Author: Cameron Guzdziol
@ Date: 9/28/2017
@ Class: 1500 Thursday 1 PM
@ Program: Estimate how much a sales tax increase of 1% would cost a user
*/

import java.text.DecimalFormat;
import java.util.Scanner;


public class SalesTax
{
   // constant tax rates
   public static final double RONE = .06;
   public static final double RTWO = .07;
   
   public static void main(String[] args)
   {
      
      // All other variables
      double inc;    // Income
      double incpr;  // Percent income taxable
      double inctax; // Tax Income
      double taxc;   // Tax current rate
      double taxp;   // Tax proposed rate
      double dif;    // Difference between proposed and current tax
      
      // Create scanner
      Scanner input = new Scanner (System.in);
      
      // Prompt for and save inc and incpr
      System.out.println("Proposed sales tax increase program\n");
      System.out.print("What is your current income? $");
      inc = input.nextDouble();
      System.out.print("What percent of your current income is taxable (0 to 100)? ");
      incpr = input.nextDouble() * .01;
      
      // calculate
      inctax = inc      * incpr;
      taxc   = inctax   * RONE;
      taxp   = inctax   * RTWO;
      dif    = taxp     - taxc;
      
      // Set format to display values
      DecimalFormat myFormatter = new DecimalFormat("$###,###.00");      
      
      // Convert numbers to formatted strings
      String sinctax = myFormatter.format(inctax);    
      String staxc = myFormatter.format(taxc);
      String staxp = myFormatter.format(taxp);
      String sdif = myFormatter.format(dif);
                        
      //Print stuff
      System.out.println("\nTaxable income: "   +  sinctax);
      System.out.println("At current 6% tax: "    +  staxc);
      System.out.println("At proposed 7% tax: "   +  staxp);
      System.out.println("Difference: "           +  sdif);
      
      
      
   }
   
}