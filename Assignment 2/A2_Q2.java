// -------------------------------------------------------------------------------
// Assignment 2
// Written by: Syed Ayaan Jilani ; 40209519
// For COMP 248 Section U - Winter 2022
// Date : 10th February 2022
// --------------------------------------------------------------------------------

/* -------------------------------------------------------------------------------
 *                        PROGRAM DESCRIPTION
 *                        
 * A Learning Function is an empirical formula which is responsible for regulating the 
 * training of an agent with respect to Machine Learning and Artificial Intelligence(AI). 
 * In this regard, given below is our prototype Learning Function, 𝑍, which tunes and 
 * regulates the training as well as learning in our AI agents. This is defined such that: 
 * 𝑍= 𝑦 ∗ Ω ,given that Ω = 0.567143 and 𝑦 is a dynamic variable, which is defined with 
 * respect to the day of the week (Mon-Sun) and the time of the day (Day-Light/Night-Time).
 * 
 * The program prompts the user to enter the Weekday and the Time as a single input 
 * separated via the space character => MoNdAy NiGHT-TiMe, Sunday Day-Light, etc.
 * If an invalid input was received; the program displays the respective error message, 
 * and terminates with a note to the user to retry again.
 * 
 * The program then processes the user’s inputs to determine the corresponding value for 
 * variable, 𝑦. Thereafter, the program computes and outputsthe resultant value for our 
 * prototype learning function, 𝑍, using the aforementioned empirical formula - 𝑍= 𝑦 ∗ Ω.
 * 
 * The program terminates by displaying a farewell message.
 *                        
 * Note - "\n" is used in most output messages in order to go to the next line 
 * to make the code more neat and human friendly.
 * -------------------------------------------------------------------------------
 */

import java.util.Scanner;

public class A2_Q2 {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Simple Machine-Learning Function Program:\n"
				+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		double Z,y; 
		double ohm = 0.567143;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter a Weekday and Time, respectively: ");
		
		String day = input.next().toLowerCase();
		String time = input.next().toLowerCase();
		
		switch(time){
		    	   
		    case "day-light":
		    	   switch (day) {
		    	        case "monday":
		    	        	y = 2.53;
		    	        	break;
		    	        case "tuesday":
		    	        	y = 3.15; 
		    	        	break;
		    	        case "wednesday":
		    	        	y = 3.00; 
		    	        	break;
		    	        case "thursday":
		    	        	y = 2.41; 
		    	        	break;
		    	        case "friday":
		    	        	y = 1.99; 
		    	        	break;
		    	        case "saturday":
		    	        	y = 3.59; 
		    	        	break;
		    	        case "sunday":
		    	        	y = 2.00; 
		    	        	break;
		    	        default:
		    	        	System.out.println("Error: an invalid value has been entered for the 'Weekday' variable. Kindly retry again!");
		    	        	y = 0.0;
		    	   }
		    	   break;	   
		    
		    case "night-time":
		    	   switch(day){
		    	        case "monday":
		    	        	y = 3.25;
		    	        	break;
		    	        case "tuesday":
		    	        	y = 2.99;
		    	        	break;
		    	        case "wednesday":
		    	        	y = 3.99;
		    	        	break;
		    	        case "thursday":
		    	        	y = 2.68;
		    	        	break;
		    	        case "friday":
		    	        	y = 3.73;
		    	        	break;
		    	        case "saturday":
		    	        	y = 2.86;
		    	        	break;
		    	        case "sunday":
		    	        	y = 2.59;
		    	        	break;
		    	        default:
		    	        	System.out.println("Error: an invalid value has been entered for the 'Weekday' variable. Kindly retry again!");
		    	        	y = 0.0;
		    	   }
		    	   break;   
		    	   
		    default:
		    	System.out.println("Error: an invalid value has been entered for the 'Time' variable. Kindly retry again!");
	        	y = 0.0;
		    	
		}
		
		Z = y * ohm;
		
		input.close();
		
		System.out.printf("\nValue of the prototype Learning Function, Z, is: %.2f",Z);
		System.out.print("\nThank you for contributing to this Machine Learning project!");

	}

}
