package gradeStatistics;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		// Array List For Holding User Inputs
		ArrayList<Float> gradeList = new ArrayList<>();
		// Array List For Holding Percent Value of Inputed Grades
		ArrayList<Float> gradePercentage = new ArrayList<>();
		// Decimal Format Method To Format Numbers To The Hundredth Place
		DecimalFormat df_var = new DecimalFormat("##.##");

		//Asks For Total Points In The Class To Calculate for Percentages
		System.out.println("Enter Total Points of Class: ");
		float totalPoints = scnr.nextFloat();

		//Loop For adding Grades to the array list
		for (int i = 0; i < 10; i++) {
			System.out.println("Enter A Grade (in points earned): ");
			float gradeInput = scnr.nextFloat();
			// if statement ensures that points entered are within the points expected for the class point total
			if (gradeInput > totalPoints) {
				System.out.println("Try Again Not Within Points Range: ");
				i = i - 1;
			} else {
				gradeList.add(gradeInput);
			}
		}

		scnr.close();

		// Takes the Array List and converts it to an Array
		Float[] gradeListToArray = gradeList.toArray(new Float[0]);

		//For Loop Applies A Letter Grade To Each User Inputed Grade
		for (int i = 0; i < 10; i++) {
			float tempPercentage = (gradeListToArray[i] / totalPoints) * 100;
			gradePercentage.add(tempPercentage);
			String letterGrade;
			if (tempPercentage >= 97.00) {
				letterGrade = "A+";
			} else if (tempPercentage >= 94.00) {
				letterGrade = "A";
			} else if (tempPercentage >= 90.00) {
				letterGrade = "A-";
			} else if (tempPercentage >= 87.00) {
				letterGrade = "B+";
			} else if (tempPercentage >= 84.00) {
				letterGrade = "B";
			} else if (tempPercentage >= 80.00) {
				letterGrade = "B-";
			} else if (tempPercentage >= 77.00) {
				letterGrade = "C+";
			} else if (tempPercentage >= 74.00) {
				letterGrade = "C";
			} else if (tempPercentage >= 70.00) {
				letterGrade = "C-";
			} else if (tempPercentage >= 67.00) {
				letterGrade = "D+";
			} else if (tempPercentage >= 64.00) {
				letterGrade = "D";
			} else if (tempPercentage >= 60.00) {
				letterGrade = "D-";
			} else {
				letterGrade = "F";
			}
			// Prints The Users Grade Percent and Letter Grade
			System.out.println(df_var.format(tempPercentage) + "% " + letterGrade);
		}

		// Sets the Grade Percentage Array List To an Array
		Float[] gradePercentageToArray = gradePercentage.toArray(new Float[0]);

		// Initilizes Average, Max, and Minimum Variables
		float gradeAvg = 0;
		float gradeMxm = 0;
		float gradeMin = gradePercentageToArray[0];

		//For Loop For Doing Avg, Min, Max Calculations
		for (int i = 0; i < 10; i++) {
			gradeAvg = gradeAvg + gradePercentageToArray[i];
			if (gradeMxm < gradePercentageToArray[i]) {
				gradeMxm = gradePercentageToArray[i];
			}
			if (gradeMin > gradePercentageToArray[i]) {
				gradeMin = gradePercentageToArray[i];
			}
		}
		gradeAvg = gradeAvg / 10;

		// Prints Results Out To The Console With Formated Decimal Points.
		System.out.println("Average: " + df_var.format(gradeAvg));
		System.out.println("Maximum: " + df_var.format(gradeMxm));
		System.out.println("Minimum: " + df_var.format(gradeMin));

	}
}
