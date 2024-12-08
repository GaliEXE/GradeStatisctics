package gradeStatistics;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		ArrayList<Float> gradeList = new ArrayList<>();
		ArrayList<Float> gradePercentage = new ArrayList<>();
		DecimalFormat df_var = new DecimalFormat("##.##");

		System.out.println("Enter Total Points of Class: ");
		float totalPoints = scnr.nextFloat();

		for (int i = 0; i < 10; i++) {
			System.out.println("Enter A Grade (in points earned): ");
			float gradeInput = scnr.nextFloat();
			if (gradeInput > totalPoints) {
				System.out.println("Try Again Not Within Points Range: ");
				i = i - 1;
			} else {
				gradeList.add(gradeInput);
			}
		}

		scnr.close();

		Float[] gradeListToArray = gradeList.toArray(new Float[0]);

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
			System.out.println(df_var.format(tempPercentage) + "% " + letterGrade);
		}

		Float[] gradePercentageToArray = gradePercentage.toArray(new Float[0]);
		float gradeAvg = 0;
		float gradeMxm = 0;
		float gradeMin = gradePercentageToArray[0];
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
		System.out.println("Average: " + df_var.format(gradeAvg));
		System.out.println("Maximum: " + df_var.format(gradeMxm));
		System.out.println("Minimum: " + df_var.format(gradeMin));

	}
}
