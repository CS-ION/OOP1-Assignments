

/* -------------------------------------------------------------------------------
 *                        PROGRAM DESCRIPTION
 *                        
 * The following Java program prompts the user to enter a sequence of courses with 
 * its grade in the format of “Course1|Grade1;Course2|Grade2;Course3|Grade3;” as 
 * one string.The program separates the string into the course name and grade 
 * individually and save the course names and grades in two different arrays 
 * (2D-character array for course names and integer array for grade). 
 * 
 * The program then outputs the courses taken and the numerical average of all 
 * courses along with the letter grade associated. The letter grade is calculates 
 * as follows -:
 * 
 *      Average           Grade
 *       >= 88             "A"                                    
 *		 >= 80             "B"
 *		 >= 67             "C"
 *		 >= 60             "D"
 *		  < 60             "F"
 * 
 * The program uses Integer.parseInt() to convert a string to an integer number and 
 * toCharArray() to convert a string to a character array. If the user enters 0, 
 * the program terminates by displaying no courses are taken as of now.
 * 
 * The program terminates by displaying a farewell message.
 *                        
 * Note - "\n" is used in most output messages in order to go to the next line 
 * to make the code more neat and human friendly.
 * -------------------------------------------------------------------------------
 */

import java.util.Scanner;

public class A3_Q2 {

	public static void main(String[] args) {
		
		System.out.println("-------****-------****-------****-------****-------\n"
				+ "        Welcome to Student Courses Grade Program!\n"
				+ "-------****-------****-------****-------****-------");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the courses your are taking this semester (course|grade and separated by a semicolon):");
		
		String courseData = input.nextLine();
		
		int length = 0;
		
		for (int i = 0 ; i < courseData.length() ; i++) {                 //finding the length of 1D array ie. the no of courses taken
			if (courseData.charAt(i) == ';') {length++;}
		}
		
		if (length == 0) {                                                //the program will exit of user enters 0
			System.out.println("\nYou are not taking any course now!");   //which means he is not taking any courses
			System.out.println("\nThank you for using Student Courses Grade Program!");
			System.exit(0);
		}
		
		char[][] courses = new char[length][];                            //2D char array for course name
		int[] grades = new int[length];                                   //1D char array for numerical grade
		
		String tempVar = "";
		int count = 0 , sum = 0;
		
		for (int i = 0 ; i < courseData.length() ; i++) {
			
			if (courseData.charAt(i) == ';'){
				grades[count] = Integer.parseInt(tempVar);
				count++;
				tempVar = "";
			}
			
			else if (courseData.charAt(i) == '|') {
				courses[count] = tempVar.toCharArray();
				tempVar = "";
			}
			
			else {tempVar += courseData.charAt(i);}
			
			}
		
		/* the above for loop is used to traverse through each character of the single string of grades and courses 
		 * entered by the user. "tempVar" is used to first store all the characters of the course name until a '|' 
		 * is encountered. The course name value inside "tempVar" is then inserted into the 2D char array by toCharArray().
		 * "tempVar" is then initialised to "" and is used to store the grade as a string until ';' is encountered. 
		 * The grade value inside "tempVar" is then inserted into the 1D integer array by first converting it into int by 
		 * using Integer.parseInt(). The process is then repeated until all courses and their corresponding grades are done 
		 * and stored into the array.
		 */
		
		System.out.println("\nHere is the list of courses you are taking:\n");
		
		for (int i = 0 ; i < courses.length ; i++) {                     //outputting all the elements of 2D char array ie the courses
			System.out.print("No." + (i+1) + " ");
			for (int j = 0 ; j < courses[i].length ; j++) {System.out.print(courses[i][j]);}
			System.out.println();
			sum+=grades[i];
		    }
		
		double avg = (float)sum/count;
		String grade = "";
		
		if (avg >= 88) {grade = "A";}                                       //finding the grade
		else if (avg >= 80) {grade = "B";}
		else if (avg >= 67) {grade = "C";}
		else if (avg >= 60) {grade = "D";}
		else if (avg < 60) {grade = "F";}
		
		System.out.printf("The average of your courses is %.2f and the average courses grade is: %s",avg,grade);
		
		
		System.out.println("\n\nThank you for using Student Courses Grade Program!");
		
		input.close();
	
	}

}
