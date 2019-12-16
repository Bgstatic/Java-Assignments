

import java.util.Scanner;

public class Pro5_2_150117072 {
       
	public static void main(String[] args) {

		//Bilgehan Ge�ici 150117072
		/* This program prints the binary values of the user's decimal values.
		  After that the program converts the binary numbers in specific way. The program takes the number of converting steps from user and it 
		  converts it with given step. After the converting process the program prints the decimal values of converted binary values */ 
		  
		Scanner input = new Scanner(System.in); // Creating a scanner object in order to get input from user.

		System.out.println("Welcome to our program: ");

		System.out.print("Enter a string: ");

		String string = input.nextLine(); // Getting array size from user.

		String[] number_in_strings = string.split("-");
		int[][] initial_array = new int[number_in_strings.length][number_in_strings.length]; // Creating the initial array with user's string size.

		System.out.print("Enter a number of steps: ");
		int step = Integer.parseInt(input.nextLine()); // Getting number of converting process from user.

		for (int i = 0; i < number_in_strings.length; i++) {

			int value = Integer.parseInt(number_in_strings[i]);

			int[] valueAsArray = convertDectoB(value, number_in_strings.length); /* Creating a one dimensional array and 
                                                                                  fill it with binary values which is 
                                                                                  initial array's decimal values.*/
			for (int j = 0; j < number_in_strings.length; j++) {

				initial_array[i][j] = valueAsArray[j]; 

			}
			System.out.println();

		}

		printArray(initial_array); // Printing the initial array with its binary values.
		calculateArray(initial_array, step);  // Printing the initial array with given number of converting steps. 

	}

	public static int[] convertDectoB(int number, int size) { // Creating a method for converting the initial array's decimal values into to the binary values.

		int[] array = new int[size];
		int counter = size - 1;
		int a = 0;
		String x = "";
		while (number > 0) {

			a = number % 2;

			x = x + "" + a;
			number = number / 2;

			array[counter] = a;
			counter--;
		}
		return array;

	}

	public static void convertBinarytoD(int[][] array, int step) { // Creating a method for printing the decimal values of converted array.

		String result = "";
		int i = 0;
		int j = 0;
		int total = 0;

		for (i = 0; i < array.length; i++) {

			total = 0;

			for (j = 0; j < array.length; j++) {

				total += array[i][j] * Math.pow(2, array.length - j - 1);

			}

			result += total + "-";

		}

		System.out.println(" The decimal value for the second table after " + step + " steps:"
				+ result.substring(0, result.length() - 1));

	}

	public static void calculateArray(int[][] inputArray, int repeatCount) { // Creating a method for printing array in converted type.

		int[][] resultArray = inputArray;

		for (int i = 0; i < repeatCount; i++) {

			if (i == 10) {

				System.out.println("It is converted to the following table after " + (int) (i + 1) + "th step:");

			} else if (i == 11) {
				
				System.out.println("It is converted to the following table after " + (int) (i + 1) + "th step:");

			}
			else if( i == 12) {
				
				System.out.println("It is converted to the following table after " + (int) (i + 1) + "th step:");
			}

			else if (i % 10 == 0) {

				System.out.println("It is converted to the following table after " + (int) (i + 1) + "st step:");
			} else if (i % 10 == 1) {

				System.out.println("It is converted to the following table after " + (int) (i + 1) + "nd step:");
			} else if (i % 10 == 2) {

				System.out.println("It is converted to the following table after " + (int) (i + 1) + "rd step:");
			} else if (i % 10 >= 3) {

				System.out.println("It is converted to the following table after " + (int) (i + 1) + "th step:");
			}

			resultArray = calculateMirror(resultArray);

			printArray(resultArray); // Printing the array in converted type.
		}
		convertBinarytoD(resultArray, repeatCount); // Printing the converted array's decimal result.

	}

	private static void printArray(int[][] resultArray) { // Creating a method for printing the array with given format.

		printLine(resultArray.length);
		System.out.println();
		for (int i = 0; i < resultArray.length; i++) {

			System.out.print("|");
			for (int j = 0; j < resultArray.length; j++) {

				System.out.print(" " + resultArray[i][j] + " |");

			}

			System.out.println();

			printLine(resultArray.length);

			System.out.println();

		}
	}

	private static void printLine(int length) { // Creating a method for printing dashes based on array's size

		for (int i = 0; i < (length * 4) + 1; i++) {

			System.out.print("-");
		}

	}

	private static int[][] calculateMirror(int[][] inputArray) {
		int[][] resultArray = new int[inputArray.length][inputArray.length];

		for (int i = 0; i < resultArray.length; i++) {

			for (int j = 0; j < resultArray.length; j++) {

				int currentCellValue = inputArray[i][j];

				int[] neighborsOfTheCurrentCell = getNeighborsOfTheCell(inputArray, i, j);

				int newValue = calculateNewValue(currentCellValue, neighborsOfTheCurrentCell);

				resultArray[i][j] = newValue;

			}
		}

		return resultArray;
	}

	private static int calculateNewValue(int currentCellValue, int[] neighborsOfTheCurrentCell) { /*  Creating a method for converting the initial array's 
                                                                                                  binary values with given rule.*/
		int result = 0;

		if (currentCellValue == 1) {

			if (neighborsOfTheCurrentCell[1] == 2 || neighborsOfTheCurrentCell[1] == 3)
				result = 1;
			else
				result = 0;

		} else {

			if (neighborsOfTheCurrentCell[1] == 3)
				result = 1;
			else
				result = 0;

		}

		return result;
	}

	private static int[] getNeighborsOfTheCell(int[][] inputArray, int i, int j) { // Creating a method for checking the neighbors of the array and takes the number of ones and zeros.

		int[] result = new int[2];
		// : index 0 contains count of 0
		// : index 1 contains count of 1

		int counterforZero = 0, counterForOne = 0;

		for (int p = i - 1; p <= i + 1; p++) {

			for (int q = j - 1; q <= j + 1; q++) {

				if (p >= 0 && q >= 0 && !(p == i && q == j) && p < inputArray.length && q < inputArray.length) {

					if (inputArray[p][q] == 1)
						counterForOne++;
					else
						counterforZero++;

				}

			}

		}

		result[0] = counterforZero;

		result[1] = counterForOne;

		return result;
	}

}
