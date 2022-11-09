
/* -------------------------------------------------------------------------------
 *                            PROGRAM DESCRIPTION
 *                            
 * The following Java program prompts the user to input the Purchase Value (P) and
 * Salvage Value (S) of an asset (in $) along with the no. of years (Y) the asset was used.
 * Note - all three values are entered together separated by spaces
 *
 * The program calculates and outputs the following :-
 * 1) Yearly Depriciation Value [D = (P - S) / Y]
 * 2) Yearly depreciation Percentage [dPercentage = (D/P) × 100]
 * 3) Number of years for salvage value to become 50% of purchase price [yHalfValue = (P - (P/2))/D]
 * 
 * The program terminates by displaying a farewell message.
 * 
 * Note - "\n" is used in most output messages in order to go to the next line 
 * to make the code more neat and human friendly.
 * 
 * -------------------------------------------------------------------------------
 */

import java.util.Scanner;
import java.lang.Math;

public class A1_Q2 {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Asset Depriciation Tool:\n"
				+ "--------------------------------------------------------------------");
		
		Scanner input = new Scanner(System.in);                    //creating Scanner Object//
		
		System.out.println("Enter the values (Price($), Salvage value($), and Years used) with space between them:");
		
		double P = input.nextDouble();                             //values of P,S,Y are taken in single line separated by space[" "]
		double S = input.nextDouble();                             //nextDouble() [delimiter - " "] is used to parse the values
		double Y = input.nextDouble();                                
		
		input.close();                                             //closing the Scanner

		double D = Math.round(((P-S)/Y)*100)/100.0;                                      
		double dPercentage = Math.round(((D/P)*100)*100)/100.0; 
        double yHalfValue = Math.round(((P-(P/2))/D)*100)/100.0;     
        
		/* For calculating all the results upto TWO DECIMAL PLACES, we first multiply the decimal result by 
		 * 100 to shift the decimal point to the right by 2 places because we intend on rounding off to two decimal places.
		 * 
		 * Then using Math.round() to round off the result to the nearest integer which returns a long 
		 * value which we divide by 100.0 to shift the decimal point to the left by two places.
		 * This gives us our final answer rounded off to two decimal places.
		 * 
		 * Note: we divided by 100.0 so that the compiler understands it to be a floating-point division 
		 * operation so that we get our final answer rounded off to two decimal places. If we simply divide 
		 * by 100 then the compiler assumes it to be integer division as Math.round() returns a long value 
		 * and we will get an integer as our final answer with .0 added to the end because we declared the 
		 * variables to be of double datatype. */
        
		System.out.println("Yearly depreciation = $" + D);        
		System.out.println("Yearly depreciation % = " + dPercentage +'%');
		System.out.println("Number of years for salvage value to become 50% of purchase price = " + yHalfValue + " years");
	   
		System.out.println("\nThank you for using Asset depreciation tool.\n\n"
				+ "See you next time.");                          
	}

}
