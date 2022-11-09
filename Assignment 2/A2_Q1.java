

/* -------------------------------------------------------------------------------
 *                        PROGRAM DESCRIPTION
 *                        
 * The following Java program prompts the user to enter the Symptom Code (sCode),
 * an integer value. The program then processes the input and outputs the category 
 * which symptom belongs to and displays instructions about what to do next.
 * 
 * The Symptom Codes: 10-13, 14-20, and 21-23 indicate the Most Common Symptoms, 
 * the Less Common Symptoms, and the Critical Symptoms of COVID-19, respectively.
 * Symptom Codes (-128)-9 and 24-127 indicate No Obvious Symptoms
 * 
 * The program also validates the user's input to ensure that the correct value
 * is entered. If an invalid input was received; the program displays the respective 
 * error message, and terminates with a note to the user to retry again.
 * 
 * The program also displays all the Symptom Codes (from 10 - 23 only) 
 * and the corresponding Symptom Descriptions to the user using the format: 
 * Symptom Code => Symptom Description
 * 
 * The program terminates by displaying a farewell message.
 *                        
 * Note - "\n" is used in most output messages in order to go to the next line 
 * to make the code more neat and human friendly.
 * -------------------------------------------------------------------------------
 */


import java.util.Scanner;

public class A2_Q1 {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Simple COVID-19 Diagnostics Expert System:\n"
				+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n"
				+ "Symptom Code => Symptom Description\n"
				+ "------------------------------------\n"
				+ "10 => Fever \n"
				+ "11 => Cough \n"
				+ "12 => Tiredness \n"
				+ "13 => Loss of Taste and/or Smell \n"
				+ "14 => Sore Throat \n"
				+ "15 => Headache \n"
				+ "16 => Body Aches and/or Pains \n"
				+ "17 => Diarrhoea \n"
				+ "18 => Skin Rash \n"
				+ "19 => Fingers/Toes Discoloration \n"
				+ "20 => Red and/or Irritated Eyes \n"
				+ "21 => Shortness of Breath \n"
				+ "22 => Confusion and/or Loss of Speech \n"
				+ "23 => Chest Pains\n");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the Symptom Code, from the aforementioned, that corresponds to your current health symptoms: ");
		
		if (!(input.hasNextInt())) {
			System.out.println("Error: Your input/entry is not a valid integer between -128 to 127. Kindly retry again!");
			input.close();
			System.exit(0);
		}
			
		int sCode = input.nextInt();
		
		if (sCode >= 10 && sCode <= 20) {
			if (sCode >= 10 && sCode <=13) {System.out.println("Symptom Status: MOST COMMON SYMPTOM");} else {System.out.println("Symptom Status: LESS COMMON SYMPTOM");}
			System.out.println("You are experiencing a common symptom with regard to either COVID-19 or a respiratory infection (e.g. flu).");
		    System.out.println("Kindly isolate yourself as soon as possible, and endeavor to perform a PCR (Polymerase Chain Reaction) test to confirm your COVID-19 status.");		
		}
		
		else if (sCode >= 21 && sCode <= 23) {
			System.out.println("Symptom Status: CRITICAL SYMPTOM");
			System.out.println("You are experiencing a CRITICAL/SEVERE symptom with regard to either COVID-19 or a respiratory infection (e.g. flu).");
			System.out.println("Kindly isolate yourself as soon as possible and call 911, immediately.");
		}
		
		else if ((sCode >= 24 && sCode <= 127) || (sCode >= -128 && sCode <= 9)) {
			System.out.println("Symptom Status: NO OBVIOUS SYMPTOM");
			System.out.println("You are currently experiencing no observable symptom with regard to either COVID-19 or a respiratory infection (e.g. flu).");
			System.out.println("Although, you may be asymptomatic. Thus, kindly adhere to all the COVID-19 safety regulations within your city and province.");
		}
		
		else {System.out.println("Error: Your input/entry is not a valid integer between -128 to 127. Kindly retry again!");}
	
		input.close();
		System.out.print("\nThank you! Please stay safe and healthy.");

	}

}
