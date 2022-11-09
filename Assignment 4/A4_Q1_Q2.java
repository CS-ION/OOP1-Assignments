// -------------------------------------------------------
// Assignment 4
// Written by: Syed Ayaan Jilani ; 40209519
// For COMP 248 Section U – Winter 2022
// Date : 13th April 2022
// --------------------------------------------------------

/* -------------------------------------------------------------------------------
 *                        PROGRAM DESCRIPTION
 *                        
 * This Java Program is a simple Classroom Management System to effectively and 
 * efficiently manage the registrants (students) and their corresponding classroom 
 * activities.
 * 
 * The program contains a private class Comp248secU (which is an instance of COMP-248
 * course at the Gina Cody School of Computer Science and Engineering). This class 
 * possesses the following members (attributes/variables and methods) which are 
 * expressed, via their respective signatures, in the table below.
 
 *                             VARIABLES
                           
 *  Access Modifier    Instance/Static     Identifier          (Return)Data Type
 
    private            static              classSize           int
    private            static              semesterYear        String
    private            static              lectureRoom         String
    private            static              instructorFname     String
    private            static              instructorLname     String
    private            instance            studFname           String[]
    private            instance            studLname           String[]
    private            instance            studID              int[]
    private            instance            assgt1              double[]
    private            instance            assgt2              double[]
    private            instance            assgt3              double[]
    private            instance            assgt4              double[]
    private            instance            labs                double[]
    private            instance            midTerm             double[]
    private            instance            finalExam           double[]

 *                      METHODS (DEFINED IN HANDOUT)

 *  Access Modifier    Instance/Static     Identifier                       (Return)Data Type
 
    public             instance            Comp248secU(String fname,        
                                           String lname, String room, 
                                           String semYr, int size)
                                           
    public             instance            addStudent(String fname,         void
                                           String lname, int studID, 
                                           int arrIdx)

    public             instance            getStudentIdx(int studID)        int

    public             instance            getStudentInfo(int studID)       String[]

    public             instance            delStudent(int studID)           int

    public             instance            updateStudentPart(String         int
                                           fname, String lname, int 
                                           studID)

    public             instance            updateAssgtScore(double a1,      int
                                           double a2, double a3, 
                                           double a4, int studID)
                                           
    public             instance            updateOtherScore(double lab,     int
                                           double test, double exam, 
                                           int studID)

    public             instance            computeWeightScore(int studID)   double

    public             static              computeGrade(double wgtScore)    char
    
    public             static              findMin(double[] dataArr)        double

    public             static              findMax(double[] dataArr)        double

    public             static              findAvg(double[] dataArr)        double

    public             instance            getClassMin()                    double[]

    public             instance            getClassMax()                    double[]

    public             instance            getClassAvg()                    double[]

    public             instance            classReportCard()                void
 
 *                         METHODS (PROGRAMMER DEFINED)

 *  Access Modifier    Instance/Static     Identifier                       (Return)Data Type
 
    public             static              getNumOfStudents(                int
                                           Comp248secU obj)
                                           
    public             static              updatedArray(double[]            double[]
                                           array, int length)
    
    public             static              dupChecker(int[] array,          boolean
                                           int StudID)
 * 
 * Aside from the above programmer defined methods, setters and getters for all the 5 static
 * variables have also been defined.
 * 
 * An object of the Comp248secU class is created in the driver class - A1_Q1_Q2. The driver 
 * class is set up as a menu-driven class that prompts the user to enter a byte value in 
 * order to manage (add, update, delete, etc.) the information in the Comp248secU object.
 * 
 * More detailed explanations of the variables/methods and their working is described 
 * as the program progresses.
 * 
 * Note: input.next() and input.nextLine() are used in various places in order to empty 
 * the buffer.
 * 
 * -------------------------------------------------------------------------------
 */

import java.util.Scanner;

class Comp248secU {
	
	//STATIC VARIABLES//
	private static int classSize;
	private static String semesterYear;
	private static String lectureRoom;
	private static String instructorFname;
	private static String instructorLname ;
	
	//INSTANCE VARIABLES//
	private String[] studFname;
	private String[] studLname;
	private int[]  studID ;
	private double[] assgt1;
	private double[] assgt2;
	private double[] assgt3;
	private double[] assgt4;
	private double[] labs;
	private double[] midTerm;
	private double[] finalExam;
	
	/* The instance arrays are designed such that each student has a particular index number
	 * associated with them in which their info is stored. For example, the first student to
	 * be registered is Ayaan Jilani of Student ID 44444444. This means that the index number 
	 * associated with Ayaan will be 0 as studID[0], studFname[0], assgt1[0], and so on will 
	 * contain the information of Ayaan.
	 */
	
	public Comp248secU (String fname, String lname, String room, String semYr, int size) {
		
		/* Constructor - sets the static variables to the values entered by the user.
		 * initializes the length of all the instance variable arrays to the classroom
		 * size entered by the user.
		 */
		
		Comp248secU.setInstructorFname(fname);
		Comp248secU.setInstructorLname(lname);
		Comp248secU.setLectureRoom(room);
		Comp248secU.setSemesterYear(semYr);
		Comp248secU.setClassSize(size);
		
		this.studID = new int[size];
		this.studFname = new String[size];
		this.studLname = new String[size];
		this.assgt1 = new double[size];
		this.assgt2 = new double[size];
		this.assgt3 = new double[size];
		this.assgt4 = new double[size];
		this.labs = new double[size];
		this.midTerm = new double[size];
		this.finalExam = new double[size];
	}
	
	public static int getNumOfStudents(Comp248secU obj) {
		
		/* This method returns the number of students that are currently
		 * regsitered in the Comp248secU object. This helps in finding
		 * the index of the array to which a new student will be added or
		 * the total number of students that should be compared to find 
		 * the max.min and average values. 
		 */
		
		for (int i = 0 ; i < obj.studID.length ; i++) {
			
			if (obj.studID[i] == 0) {
				return i;
			}
		}
		
		return obj.studID.length;
			}
	
	public static boolean dupChecker(int[] array, int StudID) {
		
		/* This method check if the student with the studentID 
		 * entered by the user already exists. It returns true 
		 * if the student already exists and false otherwise.
		 */
		
		for (int i = 0 ; i < array.length ; i++) {
			if (array[i] == StudID) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public void addStudent(String fname, String lname, int studID, int arrIdx) {
		
		/* This method adds a new student by setting up his firstname, lastname and 
		 * studentID entered by the user into the respective arrays. The value of 
		 * arrIdx (which helps to get the index number in the arrays to which the 
		 * student's information should be added to to) is derived from the 
		 * getNoOfStudents(Comp248secU obj) method. The method also checks if the 
		 * class is full or student already exists and returns the message accordingly.
		 */
		
	    if (Comp248secU.dupChecker(this.studID, studID)) {
	    	System.out.println("Student with ID: " + studID + " already exists.");
	    }
	    
	    else if (arrIdx == this.studID.length) {
		    System.out.println("Student with ID: " + studID + " CANNOT be added. Class is already full.");
		}

	    else {
			this.studID[arrIdx] = studID;
			this.studFname[arrIdx] = fname;
			this.studLname[arrIdx] = lname;
			System.out.println("Student with ID: " + studID + " added successfully.");
		}
		
	}
	
	public int getStudentIdx(int studID) {
		
		/* This method returns the index number of the arrays in
		 * which the information of the student is stored.
		 * Returns -1 if the student is not found.
		 * 
		 */
		for (int i = 0 ; i < this.studID.length ; i++) {
			if (this.studID[i] == studID) {
				return i;
			}
		}
		return -1;
	}
	
	public String[] getStudentInfo(int studID) {
		
		/* This method returns a String array of information regarding the student
		 * to be searched. The student is searched using the StudentID entered by 
		 * the user. The studentID is then used to get the index number by the 
		 * getStudentIdx(studID) method. The method then uses the index number 
		 * to retreive all the info of the student and returns them in the form 
		 * of a String array. If -1 is returned, which means that the student 
		 * does not exist, then the method returns a String of arrays containing 
		 * the relevant messages.
		 */
		
		int pos = this.getStudentIdx(studID);
		
		if (pos == -1) {
			String[] info = {"Student with ID: " + studID + " does NOT exist.",
					"Unable to retrieve information for Student with ID: " + studID
					};
			return info;
			}
		
		
		else {
			String[] info = { "Student's First Name = " + this.studFname[pos],
					"Student's Last Name = " + this.studLname[pos],
					"Student's ID = " + this.studID[pos],
					"Score in Assignment 1 = " + this.assgt1[pos],
					"Score in Assignment 2 = " + this.assgt2[pos],
					"Score in Assignment 3 = " + this.assgt3[pos],
					"Score in Assignment 4 = " + this.assgt4[pos],
					"Cummulative Score in Labs = " + this.labs[pos],
					"Mid-Term Test Score = " + this.midTerm[pos],
					"Final Examination Score = " + this.finalExam[pos]
					};
			
			return info;
		}
			

	}
	
	public int delStudent(int studID) {
		
		/* This method uses the StudentID to delete a registered student 
		 * from the object. The studentID is then used to get the index 
		 * number by the getStudentIdx(studID) method. After each delete,
		 * the index of the array is decremented by -1 and the last index 
		 * values of the arrays are assigned their default values. The 
		 * method returns 1 if the deletion is successfull. If -1 is 
		 * returned, which means that the student does not exist, then 
		 * the method returns -1.
		 */
		
		int pos = this.getStudentIdx(studID);
		
		if (pos == -1) {
			return -1;
		}
		else {
			for (int i = pos; i < this.studID.length-1; i++) {
				this.studID[i] = this.studID[i+1]; 
				this.studFname[i] = this.studFname[i+1]; 
				this.studLname[i] = this.studLname[i+1]; 
				this.assgt1[i] = this.assgt1[i+1]; 
				this.assgt2[i] = this.assgt2[i+1]; 
				this.assgt3[i] = this.assgt3[i+1]; 
				this.assgt4[i] = this.assgt4[i+1]; 
				this.labs[i] = this.labs[i+1]; 
				this.midTerm[i] = this.midTerm[i+1]; 
				this.finalExam[i] = this.finalExam[i+1]; 
			}
			
			this.studID[this.studID.length-1] = 0; 
			this.studFname[this.studID.length-1] = null; 
			this.studLname[this.studID.length-1] = null; 
			this.assgt1[this.studID.length-1] = 0.0; 
			this.assgt2[this.studID.length-1] = 0.0; 
			this.assgt3[this.studID.length-1] = 0.0; 
			this.assgt4[this.studID.length-1] = 0.0; 
			this.labs[this.studID.length-1] = 0.0; 
			this.midTerm[this.studID.length-1] = 0.0; 
			this.finalExam[this.studID.length-1] = 0.0; 
			
			return 1;
		}
	}
	
	public int updateStudentPart(String fname, String lname, int studID) {
		
		/* This method is used to update the Firstname and Lastname 
		 * (entered by the user) of analready added student based on the 
		 * studentID entered by the user. The studentID is then used to 
		 * get the index number by the getStudentIdx(studID) method. The 
		 * method returns 1 if the update is successfull. If -1 is 
		 * returned, which means that the student does not exist, then 
		 * the method returns -1.
		 */
		
        int pos = this.getStudentIdx(studID);
		
		if (pos == -1) {
			return -1;
		}
		
		else {
			this.studFname[pos] = fname;
			this.studLname[pos] = lname;
			return 1;
		}
	}
	
	public int updateAssgtScore(double a1, double a2, double a3, double a4, int studID) {
		
		/* This method is used to update the assigment scores (entered by the user)
		 * of an already added student based on the studentID entered by 
		 * the user. The studentID is then used to get the index number by
		 * the getStudentIdx(studID) method. The method returns 1 if the 
		 * update is successfull. If -1 is returned, which means that the 
		 * student does not exist, then the method returns -1. The method
		 * returns 0 if incorrect values of scores is entered.
		 */
		
        int pos = this.getStudentIdx(studID);
		
		if (pos == -1) {
			return -1;
		}
		
		else if (a1<0 || a1>20 || a2<0 || a2>20 || a3<0 || a3>20 || a4<0 || a4>20) {
			return 0;
		}
		
		else {
			this.assgt1[pos] = a1;
			this.assgt2[pos] = a2;
			this.assgt3[pos] = a3;
			this.assgt4[pos] = a4;
			return 1;
		}
	}
	
	public int updateOtherScore(double lab, double test, double exam, int studID) {
		
		/* This method is used to update the lab, midterm and final exam scores 
		 * (entered by the user) of an already added student based on the studentID 
		 * entered by the user. The studentID is then used to get the index number by
		 * the getStudentIdx(studID) method. The method returns 1 if the update is 
		 * successfull. If -1 is returned, which means that the student does not exist,
		 *  then the method returns -1.The method returns 0 if incorrect values of 
		 *  scores is entered.
		 */
		
        int pos = this.getStudentIdx(studID);
		
		if (pos == -1) {
			return -1;
		}
		
		else if (lab<0 || lab>12 || test<0 || test>30 || exam<0 || exam>40) {
			return 0;
		}
		
		else {
			this.labs[pos] = lab;
			this.midTerm[pos] = test;
			this.finalExam[pos] = exam;
			return 1;
		}
	}
	
	public double computeWeightScore(int studID) {
		
		/* This method returns a double value of the total weight score 
		 * of a student (out of 100) based on their assignments, labs and
		 * exam scores. The marking grid is given below:
		 * 
		 * Assessment           Max. Score        % Weight
           Assignment1          20                2
           Assignment2          20                3
           Assignment3          20                5
           Assignment4          20                8
           CummulativeLabs      12                12
           MidTerm              30                30
           FinalExam            40                40 
         *
         * The studentID (entered by the user) is then used to get the index 
         * number by the getStudentIdx(studID) method. If -1 is returned, 
         * which means that the student does not exist, then the method returns -1.
		 */
		int pos = this.getStudentIdx(studID);
		
		if (pos == -1) {
			return -1;
		}
		
		double a1Score = (this.assgt1[pos]/20.0)*2;
		double a2Score = (this.assgt2[pos]/20.0)*3;
		double a3Score = (this.assgt3[pos]/20.0)*5;
		double a4Score = (this.assgt4[pos]/20.0)*8;
		
		return a1Score + a2Score + a3Score + a4Score + this.labs[pos] + this.midTerm[pos] + this.finalExam[pos];
	
	}
	
	public static char computeGrade(double wgtScore) {
		
		/* This method returns the char "Grade" based on the
		 * wgtScore calculated by the computeWeightScore(int studID).
		 */
		
		if (wgtScore >= 88) {return 'A';}
		else if (wgtScore >= 80) {return 'B';}
		else if (wgtScore >= 67) {return 'C';}
		else if (wgtScore >= 60) {return 'D';}
		else {return 'F';}
		
	}
	
	public static double[] updatedArray(double[] array , int length) {
		
		/* This method return the new updated array of ONLY the registered
		 * students based on the double[] assignment/lab/exam array passed
		 * and the length which is the total number of registered students
		 * derived by the getNumOfStudents(Comp248secU obj) method. The 
		 * returned updated array helps us in finding the min and avg below.
		 */
		
		double[] newArr = new double[length];
		
		for (int i = 0 ; i < newArr.length ; i++) {
			newArr[i] = array[i];
		}
		
		return newArr;
		
	}
	
	public void classReportCard() {
		
		/* This method prints out the report card of all the students registered
		 * in the class in a formatted and human readable form. This method 
		 * internally calls the getClassMin(), getClassMax and getClassAvg()
		 * which to get the class min, max and avg for each of the 7 assessments.
		 */
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.printf("%-15s %-15s %-8s %5s %5s %5s %5s %5s %5s %5s %5s %s\n","First Name","Last Name","Stud. ID","A1","A2","A3","A4","Labs","Test","Exam","Wgt.","*");
		System.out.println("------------------------------------------------------------------------------------------");
		
		for (int i = 0 ; i < this.studID.length; i++) {
			if (this.studID[i]!=0) {
			System.out.printf("%-15s %-15s %-8s %5.2f %5.2f %5.2f %5.2f %5.2f %5.2f %5.2f %5.2f %s",
					this.studFname[i],this.studLname[i],this.studID[i],this.assgt1[i],this.assgt2[i],this.assgt3[i],this.assgt4[i],
					this.labs[i],this.midTerm[i],this.finalExam[i],this.computeWeightScore(this.studID[i]),computeGrade(this.computeWeightScore(this.studID[i])));
			System.out.println();}
		}
		
		System.out.println("\n------------------------------------------------------------------------------------------");
		
		double[] min = this.getClassMin();
		double[] max = this.getClassMax();
		double[] avg = this.getClassAvg();
		
		System.out.printf("%39s  ","Minimum Score in Class:");
		for (int i = 0 ; i<min.length ; i++) {
			System.out.printf("%5.2f ",min[i]);
		}
		
		System.out.printf("\n%39s  ","Average Score in Class:");
		for (int i = 0 ; i<avg.length ; i++) {
			System.out.printf("%5.2f ",avg[i]);
		}
		
		System.out.printf("\n%39s  ","Maximum Score in Class:");
		for (int i = 0 ; i<max.length ; i++) {
			System.out.printf("%5.2f ",max[i]);
		}
		
		System.out.println("\n------------------------------------------------------------------------------------------");

	}
	
	public double[] getClassMin() {
		
		/* This method returns an array of 7 elements which contains the 
		 * minimum score of every 7 assessments in the class. This method 
		 * internally calls the findMin(double[] array) method to find out 
		 * the minimum of every assessment. findMin(double[] array) takes in
		 * the updated array of only the registered students by calling the 
		 * updatedArray(double[] array, int length) for every assessment.
		 * The length or the no of students registered is found out by calling
		 * the getNoOfStudents(Comp248secU obj) method.
		 */
		
		double[] array = new double[7];
		
		array[0] = findMin(Comp248secU.updatedArray(this.assgt1, Comp248secU.getNumOfStudents(this)));
		array[1] = findMin(Comp248secU.updatedArray(this.assgt2, Comp248secU.getNumOfStudents(this)));
		array[2] = findMin(Comp248secU.updatedArray(this.assgt3, Comp248secU.getNumOfStudents(this)));
		array[3] = findMin(Comp248secU.updatedArray(this.assgt4, Comp248secU.getNumOfStudents(this)));
		array[4] = findMin(Comp248secU.updatedArray(this.labs, Comp248secU.getNumOfStudents(this)));
		array[5] = findMin(Comp248secU.updatedArray(this.midTerm, Comp248secU.getNumOfStudents(this)));
		array[6] = findMin(Comp248secU.updatedArray(this.finalExam, Comp248secU.getNumOfStudents(this)));
		
		return array;

	}
	
	public static double findMin(double[] array){
		
		if (array.length==0) {return 0.0;}
		
		double min = array[0];

		for (int i = 0 ; i < array.length ; i++) {
			if (array[i]<min) {min = array[i];}
		}

		return min;
	}
	
	public double[] getClassMax() {
		
		/* This method returns an array of 7 elements which contains the 
		 * maximum score of every 7 assessments in the class. This method 
		 * internally calls the findMax() method to find out the maximum
		 * of every assessment. Notice that we do not need to pass the 
		 * updated array as we will get back the max value anyways if we 
		 * pass the whole original array of the size of the classSize.
		 */
		
		double[] array = new double[7];
		
		array[0] = findMax(this.assgt1);
		array[1] = findMax(this.assgt2);
		array[2] = findMax(this.assgt3);
		array[3] = findMax(this.assgt4);
		array[4] = findMax(this.labs);
		array[5] = findMax(this.midTerm);
		array[6] = findMax(this.finalExam);
		
		return array;

	}
	
	public static double findMax(double[] array){
		
		double max = 0;
		
		for (int i = 0 ; i < array.length ; i++) {
			if (array[i]>max) {max = array[i];}
		}
		
		return max;
	}
	
	public double[] getClassAvg() {
		
		/* This method returns an array of 7 elements which contains the 
		 * average score of every 7 assessments in the class. This method 
		 * internally calls the findAvg() method to find out the average
		 * of every assessment. findAvg(double[] array) takes in
		 * the updated array of only the registered students by calling the 
		 * updatedArray(double[] array, int length) for every assessment.
		 * The length or the no of students registered is found out by calling
		 * the getNoOfStudents(Comp248secU obj) method.
		 */
		
		double[] array = new double[7];
		
		array[0] = findAvg(Comp248secU.updatedArray(this.assgt1, Comp248secU.getNumOfStudents(this)));
		array[1] = findAvg(Comp248secU.updatedArray(this.assgt2, Comp248secU.getNumOfStudents(this)));
		array[2] = findAvg(Comp248secU.updatedArray(this.assgt3, Comp248secU.getNumOfStudents(this)));
		array[3] = findAvg(Comp248secU.updatedArray(this.assgt4, Comp248secU.getNumOfStudents(this)));
		array[4] = findAvg(Comp248secU.updatedArray(this.labs, Comp248secU.getNumOfStudents(this)));
		array[5] = findAvg(Comp248secU.updatedArray(this.midTerm, Comp248secU.getNumOfStudents(this)));
		array[6] = findAvg(Comp248secU.updatedArray(this.finalExam, Comp248secU.getNumOfStudents(this)));
		
		return array;

	}
	
	public static double findAvg(double[] array){
		
		double sum = 0;
		
		for (int i = 0 ; i < array.length ; i++) {
			sum += array[i];	
		}
		
		if (array.length!=0) {return sum/array.length;} else {return 0.0;}
	}
	
	//SETTERS AND GETTERS FOR ALL THE STATIC VARIABLES

	public static int getClassSize() {
		return classSize;
	}

	public static void setClassSize(int classSize) {
		Comp248secU.classSize = classSize;
	}

	public static String getSemesterYear() {
		return semesterYear;
	}

	public static void setSemesterYear(String semesterYear) {
		Comp248secU.semesterYear = semesterYear;
	}

	public static String getLectureRoom() {
		return lectureRoom;
	}

	public static void setLectureRoom(String lectureRoom) {
		Comp248secU.lectureRoom = lectureRoom;
	}

	public static String getInstructorLname() {
		return instructorLname;
	}

	public static void setInstructorLname(String instructorLname) {
		Comp248secU.instructorLname = instructorLname;
	}

	public static String getInstructorFname() {
		return instructorFname;
	}

	public static void setInstructorFname(String instructorFname) {
		Comp248secU.instructorFname = instructorFname;
	}
}


public class A4_Q1_Q2 {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Simple Classroom Management System:\n" +
		"++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter instructor's particulars (FirstName, LastName, LectureRoom, Semester, MaxClassSize) as a single-line entry:");
		
		String firstname = input.next();
		String lastname = input.next();
		String room = input.next();
		String sem = input.next();
		
		if (input.hasNextInt() == false) {
			System.out.println("Error: Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly retry again!");
			input.close();
			System.exit(0);
		}
		
		// Checks if the classSize input if integer or not. The program terminates if it is not a valid integer. 
		
		int size = input.nextInt();
		
		Comp248secU obj = new Comp248secU(firstname , lastname , room , sem , size);      //creating the object of Comp248secU class
		
		//MENU
		System.out.println("\nCode => Description\r\n"
				+ "103 => Enrol New Student\n" 
				+ "106 => Find Student Position in Class List\n"
				+ "109 => Retrieve Student's Information\n" 
				+ "112 => Unenrol Student\n"
				+ "115 => Update Student's Particulars\n"
				+ "118 => Update Assignment Scores\n"
				+ "121 => Update Other Scores\n"
				+ "124 => Display Student's Report Card\n"
				+ "127 => Display Class Report Card\n"
				+ "0 ===> Exit\n");
		
		while (true) {
			
			/* The infinite while loop promts the user for a choice input unless the user enters and invalid value
			 * or a value not in the menu. Notice that each if choice has the provision to verify whether the user
			 * enters a valid integer value when prompted to enter the StudentID. If the user enters an invalid 
			 * non-integer value for the StudentID, the program displays an error message and asks the user to
			 * input choice again (the program does not terminate). In case of 118 and 121,the program displays an 
			 * error message and asks the user to input choice again (the program does not terminate) if the user 
			 * enters a non-double value for the scores.
			 */
			
			System.out.print("Please enter a Code, from the aforementioned, that corresponds to your task: ");
		
			
			if (input.hasNextByte() == false) {
				System.out.println("Error: Your input/entry is not a valid integer between -128 to 127. Kindly retry again!");
				input.close();
				System.exit(0);
			}
			
			//The program terminates if the user enters and invalid value which is not a byte (bw -127 and 128)
			
			int choice = input.nextInt();
			
			if (choice == 103 ) {
				
				int arrIdx = Comp248secU.getNumOfStudents(obj); //get the index to which the student should be added to
				
				System.out.println("\nEnrolling New Student...\n" + 
				                   "- - - - - - - - - - - - -");
				System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single-line entry:");
				
				String fname = input.next();
				String lname = input.next();
				
				if (input.hasNextInt()) {
					obj.addStudent(fname, lname, input.nextInt() , arrIdx);
				}
				else {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
					input.nextLine(); 
				}
				
				
			}
			
			else if (choice == 106 ) {
				
				System.out.println("\nFinding Student's Position in Class List...\n" + 
				                   "- - - - - - - - - - - - - - - - - - - - - -");
				System.out.println("Enter StudentID :");
				
				if (input.hasNextInt()) {
					
					int studID = input.nextInt();
					int pos = obj.getStudentIdx(studID);
					
					if (pos == -1) {
						System.out.println("Student with ID: " + studID + " does NOT exist.");
					}
					else {
						System.out.println("The position of student with ID: " + studID + ", in the class list, is: " + pos);
					}
				}
				else {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
					input.nextLine();
					input.nextLine();
				}
		
			}
			
			else if (choice == 109 ) {
				
				System.out.println("\nRetrieving Student's Information...\n" + 
		                   "- - - - - - - - - - - - - - - - - - - - - -");
		        System.out.println("Enter StudentID :");
		        
		        if (input.hasNextInt()) {
		        	String[] info = obj.getStudentInfo(input.nextInt()); //displays student details if found or
		        	for (String element : info) {                        //displays error messages if student does not exist
		        		System.out.println(element);
		        	}
		        	
		        }
		        else {
		        	System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
		        	input.nextLine();
		        	input.nextLine();
		        }
			}
			
			else if (choice == 112 ) {
				
				System.out.println("\nUnrerolling Student...\n" + 
		                   "- - - - - - - - - - - - - - - - - - - - - -");
		        System.out.println("Enter StudentID :");
		        
		        if (input.hasNextInt()) {
		        	
				    int studID = input.nextInt();
		        	int result = obj.delStudent(studID);
		        	
		        	if (result == -1) { //Student does not exist
		        		String[] info = obj.getStudentInfo(studID); //displays the error message for student not found
			        	for (String element : info) {
			        		System.out.println(element);}
			        }
		        	
		        	else {
		        		System.out.println("Successfully removed Student with ID: " + studID);
		        	}
		        }
		        
		        else {
		        	System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
		        	input.nextLine();
		        	input.nextLine();
		        }
				
			}
			
			else if (choice == 115 ) {
				
				System.out.println("\nUpdating Student's Particulars...\n" + 
		                   "- - - - - - - - - - - - - - - - - - - - - -");
		        System.out.println("Enter update to student's particulars (FirstName, LastName, StudentID) as a single-line entry: ");
		        
		        String fname = input.next();
				String lname = input.next();
		        
				if (input.hasNextInt()) {
					
					int studID = input.nextInt();
					int result = obj.updateStudentPart(fname, lname, studID);
					
					if (result == -1) { //Student does not exist
		        		String[] info = obj.getStudentInfo(studID); //displays the error message for student not found
			        	for (String element : info) {
			        		System.out.println(element);}
			        }
					
					else {
						System.out.println("Successfully updated identification particulars for Student with ID: " + studID);
					}
					
				}
				
				else {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
		        	input.nextLine();
				}
		 
			}
			
			else if (choice == 118 ) {
				
				System.out.println("\nUpdating Assignment Scores...\n" + 
		                   "- - - - - - - - - - - - - - - - - - - - - -");
		        System.out.println("Enter update to student's Assignment scores (Assignment1, Assignment2, Assignment3, Assignment4, StudentID) as a single-line entry: ");
		        
		        double a1 = 0 , a2 = 0 , a3 = 0 , a4 = 0;
		        
		        //Checks if invalid value is entered for scores
		        
		        if (input.hasNextDouble()) {a1 = input.nextDouble();}
		        else {
		        	System.out.println("Error: Your input/entry for the scores is NOT a valid double. Kindly retry again!");
		        	input.next();
		        	input.nextLine();
		        	continue;
		        }
		        
		        if (input.hasNextDouble()) {a2 = input.nextDouble();}
		        else {
		        	System.out.println("Error: Your input/entry for the scores is NOT a valid double. Kindly retry again!");
		        	input.next();
		        	input.nextLine();
		        	continue;
		        }
		        
		        if (input.hasNextDouble()) {a3 = input.nextDouble();}
		        else {
		        	System.out.println("Error: Your input/entry for the scores is NOT a valid double. Kindly retry again!");
		        	input.next();
		        	input.nextLine();
		        	continue;
		        }
		        
		        if (input.hasNextDouble()) {a4 = input.nextDouble();}
		        else {
		        	System.out.println("Error: Your input/entry for the scores is NOT a valid double. Kindly retry again!");
		        	input.next();
		        	input.nextLine();
		        	continue;
		        }
		        
		        //Checks if invalid value is entered for Student ID
		        
				if (input.hasNextInt()) {
					
					int studID = input.nextInt();
					int result = obj.updateAssgtScore(a1, a2, a3, a4, studID);
					
					if (result == -1) { //Student does not exist
		        		String[] info = obj.getStudentInfo(studID); //displays the error message for student not found
			        	for (String element : info) {
			        		System.out.println(element);}
			        }
					
					else if (result == 0) {
						System.out.println("One or more of your scores entered for the assignments is not in the correct range (0-20 each). Kindly retry again!");
					}
					
					else {
						System.out.println("Successfully updated Assignments' scores for Student with ID: " + studID);
					}
					
				}
				
				else {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
		        	input.nextLine();
				}
			}
			
			else if (choice == 121 ) {
				
				System.out.println("\nUpdating Other Scores...\n" + 
		                   "- - - - - - - - - - - - - - - - - - - - - -");
		        System.out.println("Enter update to student's other scores (CummulativeLabs, MidTerm, FinalExam, StudentID) as a single-line entry: ");
		        
		        double lab = 0 , test = 0 , exam = 0;
		        
		        //Checks if invalid value is entered for scores
		        
		        if (input.hasNextDouble()) {lab = input.nextDouble();}
		        else {
		        	System.out.println("Error: Your input/entry for the scores is NOT a valid double. Kindly retry again!");
		        	input.next();
		        	input.nextLine();
		        	continue;
		        }
		        
		        if (input.hasNextDouble()) {test = input.nextDouble();}
		        else {
		        	System.out.println("Error: Your input/entry for the scores is NOT a valid double. Kindly retry again!");
		        	input.next();
		        	input.nextLine();
		        	continue;
		        }
		        
		        if (input.hasNextDouble()) {exam = input.nextDouble();}
				else {
		        	System.out.println("Error: Your input/entry for the scores is NOT a valid double. Kindly retry again!");
		        	input.next();
		        	input.nextLine();
		        	continue;
		        }
		        
		      //Checks if invalid value is entered for Student ID
		        
				if (input.hasNextInt()) {
					
					int studID = input.nextInt();
					int result = obj.updateOtherScore(lab, test, exam, studID);
					
					if (result == -1) { //Student does not exist
		        		String[] info = obj.getStudentInfo(studID); //displays the error message for student not found
			        	for (String element : info) {
			        		System.out.println(element);}
			        }
					
					else if (result == 0) {
						System.out.println("One or more of your scores entered for labs,test and exam is not in the correct range (0-12,0-30,0-40 respectively). Kindly retry again!");
					}
					
					else {
						System.out.println("Successfully updated Cummulative Labs, Mid-Term Test, and Final Examination scores for Student with ID: " + studID);
					}
					
				}
				
				else {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
		        	input.nextLine();
				}
				
			}
			
			else if (choice == 124 ) {
				
				System.out.println("\nDisplaying Student's Report Card...\n" + 
		                   "- - - - - - - - - - - - - - - - - - - - - -");
		        System.out.println("Enter StudentID :");
		        
		        if (input.hasNextInt()) {
		        	int studID = input.nextInt();
		        	String[] info = obj.getStudentInfo(studID); //displays students report card if student exists or
		        	for (String element : info) {               //displays the error messages if student not found
		        		System.out.println(element);}
		        		
		        	double wgtScore = obj.computeWeightScore(studID);  
		        	
		        	if (wgtScore != -1) { //computeWeightScore(studID) returns -1 if student does not exist
		        		char grade = Comp248secU.computeGrade(wgtScore);
		        		System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
		        		System.out.println("Student's Cummulative Weighted Score = " + wgtScore);
		        		System.out.println("Student's Final Letter Grade = " + grade);
		        	}
		        	
		        }
		        else {
		        	System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
		        	input.nextLine();
		        	input.nextLine();
		        }
				
			}
			
			else if (choice == 127 ) {
				// Displaying the report card
				System.out.println("\nDisplaying Student's Report Card...\n" + 
		                   "- - - - - - - - - - - - - - - - - -");
				obj.classReportCard();
			}
			
			else {
				// Terminates if user enters any other value not in the menu
				System.out.println("\nThank you for patronizing our Simple Classroom Management System.");
				input.close();
				System.exit(0);
			}
		
		}

	}

}