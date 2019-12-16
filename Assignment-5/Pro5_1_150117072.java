package Homeworks_and_other_programs;

import java.util.Scanner;

public class Pro5_1_150117072 {

	public static void main(String[] args) {
		
		//Bilgehan Geçici 150117072
		/*This program takes a number from user and rolls 10 six-sided dices based on user's number. 
		 After that the program takes the sum of the 10 six-sided dices and print it with stars based on user's number.  */
		
		Scanner input = new Scanner(System.in); // Creating a scanner object in order to get input from user.

		int[] sum_dice_array = new int[51]; // Creating a one-dimensional array to get the sums of the dices.

		System.out.println("Welcome to dice simulator program.");

		System.out.print("Enter a value: ");
		int value = input.nextInt();  // Getting number of stars from user.

		for (int i = 0; i < value; i++) {

			sum_dice_array[GenerateRandomNumbers() - 10]++; // Getting first index of the sum of the array and after that increment the index by one.

		}
		for (int i = 0; i < sum_dice_array.length; i++) {

			System.out.println(i + 10 + ":" + PrintStars(sum_dice_array[i])); // Printing stars with sum of the 10 dices.
		}

	}

	public static String PrintStars(int value) { //Creating a method for printing stars.

		String stars = "";
		for (int i = 0; i < value; i++) {

			stars += "*";
		}
		return stars;
	}

	public static int GenerateRandomNumbers() { // Creating a method for generating random numbers for dices.

		int sum = 0;

		for (int j = 0; j < 10; j++) {

			int dice = (int) (1 + Math.random() * 6);

			sum += dice;

		}
		return sum;
	}
}