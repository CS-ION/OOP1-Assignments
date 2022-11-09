// -------------------------------------------------------------------------------
// Assignment 3
// Written by: Syed Ayaan Jilani ; 40209519
// For COMP 248 Section U - Winter 2022
// Date : 11th March 2022
// --------------------------------------------------------------------------------

/* -------------------------------------------------------------------------------
 *                        PROGRAM DESCRIPTION
 *                        
 * The following Java program prompts the user to enter a sentence which ends with a 
 * punctuation mark which is not considered part of the word. The program then processes 
 * the input and outputs the displays the length of each word, the number of words in 
 * the sentence, the length of the shortest and longest words and the average length 
 * of the words. A word is any sequence of non-white characters. For example, I’ll is 
 * 1 word, but I will is considered 2 words.
 * 
 * The program terminates by displaying a farewell message.
 *                        
 * Note - "\n" is used in most output messages in order to go to the next line 
 * to make the code more neat and human friendly.
 * -------------------------------------------------------------------------------
 */

import java.util.Scanner;

public class A3_Q1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("-------****-------****-------****-------****-------\n"
				+ "Welcome To The SENTENCE SCAN PROGRAM!\n" 
				+ "-------****-------****-------****-------****-------");
		
		System.out.println("Please enter the sentence to scan:");
		
		int largest = 0 , smallest = 0 , sum = 0 , count = 0,tempSum = 0; 

		String word = input.nextLine();
		
		System.out.println("\n\nHere are some data about your sentence:\n");

		for (int i = 0 ; i < word.length() ; i++) {

			if (word.charAt(i) == ' ' || i == word.length()-1) {
				
				System.out.println("Word " + (count+1) + " has " + tempSum + " characters.");
				
				if (count == 0) {smallest = tempSum;}
				
				if (tempSum>largest) {largest = tempSum;}
				else if (tempSum<smallest) {smallest = tempSum;}
				
				tempSum = 0;
				count++; 
			}
			
			else {sum++;tempSum++;}
			
		}
		
		/* The above for loop is used to traverse through each character of the sentence entered by the user. The If statement inside
		 * the for loop checks if the character is a white-space (' ') or is the last character of the sentence (a punctuation mark).
		 * If it is neither of those, it will increment sum and tempSum until a white-space or last punctuation character is encountered.
		 * "sum" variable is used to track the total number of word which will help us in finding the average word length. "tempSum" 
		 * variable is used to track the length of each word and is set to 0 when a white-space or last punctuation character is encountered. 
		 * "count" variable is used to keep the track of the number of words and is incremented when a white-space or last punctuation 
		 * character is encountered. "largest" and "smallest" are initially set to 0 value. Whenever a white-space or last punctuation 
		 * character is encountered, the "largest" and "smallest" are compared with the tempSum to find out the longest word and the shortest
		 * word. When count is 0, meaning "tempSum" contains the length of the first word, "smallest" is assigned the current "tempSum" value 
		 * to provide a reference value when comparing further words to find out the shortest word.
		 */
		
		System.out.println("\n");
		System.out.println("There are " + count + " words.");
		System.out.println("The longest word has " + largest + " characters.");
		System.out.println("The shortest word has " + smallest + " characters.");
		System.out.printf("The average word length is %.2f characters.",((float)sum/count));
		System.out.print("\n\nThank you for using The SENTENCE SCAN PROGRAM!");
		
		input.close();

	}

}
