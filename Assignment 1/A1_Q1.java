// -------------------------------------------------------------------------------
// Assignment 1
// Written by: Syed Ayaan Jilani ; 40209519
// For COMP 248 Section U - Winter 2022
// Date : 21th January 2022
// ---------------------------------------------------------------------------------

/* -------------------------------------------------------------------------------
 *                        PROGRAM DESCRIPTION
 *                        
 * The following Java program prompts the user to input the weight (in pounds)
 * along with the time taken (in minutes) for the following treadmill activities :-
 * Running , Walking and Mountain Climbers.
 * 
 * The program then calculates and outputs the calories burnt for each 
 * activity using the following formula :-
 * 
 * Calories Burnt (each activity) = 0.0175 * MET * Weight (in kilograms) * Time (in minutes)
 * Metabolic Equivalents (MET) is used by the machine to measure the amount of 
 * energy that is expended during each activity.
 * 
 * The program will then display the total calories burnt by adding the calories 
 * burnt during each of the three activities.
 * 
 * The program terminates by displaying a farewell message encouraging the user
 * to keep up their good work and continue to achieve their goals.
 * 
 * Note - "\n" is used in most output messages in order to go to the next line 
 * to make the code more neat and human friendly.
 * -------------------------------------------------------------------------------
 */

import java.util.Scanner;

public class A1_Q1 {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Calories burned calculator:\n"
				+ "--------------------------------------------------------------------");
		
		/*Indexing all activities as :-
		 * 1 = Running6MPH 
		 * 2 = Walking3MPH 
		 * 3 = MountainClimbers3MPH*/
		
		int MET1 = 10, MET2 = 4, MET3 = 8;                                 //declaring MET values for each activity
		
		Scanner input = new Scanner(System.in);                            //creating scanner object
		
		System.out.println("Please enter your weight in Pounds:" + "\n");
		double weight = input.nextDouble()/2.2;                            //user inputs weight(pounds) -> converted to Kg's 
		
		System.out.print("Running time(minutes): ");
		double time1 = input.nextDouble();                                 //user inputs running time(minutes)
		double calBurn1 = 0.0175 * MET1 * weight * time1;                  //calculates calories burned(running)
				
		System.out.print("Walking time(minutes): ");
		double time2 = input.nextDouble();                                 //user inputs walking time(minutes)
		double calBurn2 = 0.0175 * MET2 * weight * time2 ;                 //calculates calories burned(walking)
				
		System.out.print("Mountain Climbers time(minutes): ");
		double time3 = input.nextDouble();                                 //user inputs mountain climers time(minutes)
		double calBurn3 = 0.0175 * MET3 * weight * time3;                  //calculates calories burned(mountain climers)
		
		input.close();                                                     //closing the scanner
		
		System.out.println("\n" + " You burned an estimated " + calBurn1 + " Calories Running," + "\n"
		+ " burned an estimated " + calBurn2 + " Calories walking, and" + "\n"
		+ " burned an estimated " + calBurn3 + " Calories Mountain Climber." + "\n"); 
		
		double totCalBurn = calBurn1 + calBurn2 +calBurn3;                 //calculates total calories burned
		System.out.println("Total calories burned = " + totCalBurn +"\n"); 
		
		System.out.print("Keep up your hard work. Your progress is amazing!\n"
			+ "Thank you for using Calories burned calculator.\n\n"           
			+ "See you soon...");                                        	
		}
}