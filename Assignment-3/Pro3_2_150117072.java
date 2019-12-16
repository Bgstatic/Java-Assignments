

import java.util.Scanner;

public class Pro3_2_150117072 {

	public static void main(String[] args) {
		// Bilgehan Ge�ici 150117072
		
		// According to the user's input this program prints the particular letter such as 'X', 'Y', 'Z' and 'W'.
		
		Scanner input = new Scanner(System.in); //Creating a scanner object in order to get input from user.

		System.out.println("Welcome to Letter Program");

		boolean isContinue = true; //Creating a boolean variable for continue after the execution.

		while (isContinue) { /* Creating a while loop body if the user wants to continue to the execution, 
		                      so the program asks the instructions to user again.*/ 

			System.out.print("Enter the size: ");

			int shape_size = input.nextInt(); // Getting shape size from user.

			while (shape_size % 2 == 0 || shape_size < 5) { /*  Creating a while loop body if the user's shape size is an 
			                                               even number or less than five. So the program asks the shape size 
			                                               to user when the user enters the correct value. */

				System.out.print("Invalid size. Enter size again: ");

				shape_size = input.nextInt();

			}

			System.out.print("Enter the letter:");

			String shape_type = input.next(); // Getting shape type from user.

	  while (!shape_type.equalsIgnoreCase("Z") && (!shape_type.equalsIgnoreCase("X") // When the user's enters a character expect for 'X', 'Y', 'Z' and 'W' then the program asks these instructions until the user enters the correct value.
	  && (!shape_type.equalsIgnoreCase("Y")) && (!shape_type.equalsIgnoreCase("W")))) {  

				System.out.print("Invalid Letter. Enter the letter again: ");

				shape_type = input.next();

			}

			switch (shape_type.toUpperCase()) { // Thanks to .toUpperCase(), we can also write in small letters.

			case "Z":

				printZ(shape_size);

				break;

			case "X":

				printX(shape_size);

				break;

			case "Y":

				printY(shape_size);

				break;

			case "W":

				printW(shape_size);

			}
			System.out.print("Would you like to continue: ");

			String answer = input.next(); // Getting answer for continue or finishing the execution from user.

			if (answer.toUpperCase().charAt(0) == 'Y') { /* if the user enters the 'Y' character, 
                                                        then all the execution starts again. */
				
			} else { // if the user enter the 'N' or another character except for 'Y', then the program ends.

				isContinue = false;

				System.out.println("Program ends...");

				System.exit(0);
			}
		}
	}

	public static void printW(int shape_size) { // Creating a method for printing 'W' . Based on user's input.
		for (int j = 0; j < shape_size; j++) {

			for (int i = 0; i < (4 * shape_size - 3); i++) {

				if (i == j || i + j == (4 * shape_size - 3) - 1 || i - j == (4 * shape_size - 3) / 2
						|| i + j == (4 * shape_size - 3) / 2) {

					System.out.print("*");

				} else {

					System.out.print(" ");
				}

			}
			System.out.println();
		}
	}

	public static void printY(int shape_size) { // Creating a method for printing 'Y'. Based on user's input.
		for (int j = 0; j < shape_size / 2 + 1; j++) {

			for (int i = 0; i < shape_size; i++) {

				if (i == j || i + j == shape_size - 1 && j < shape_size / 2) {

					System.out.print("*");

				} else if (j >= shape_size / 2 && i == shape_size / 2) {

					System.out.print("*");

				} else {

					System.out.print(" ");
				}

			}
			System.out.println();
		}
		for (int i = 0; i < shape_size / 2; i++) {

			for (int j = 0; j < shape_size / 2; j++) {

				System.out.print(" ");
			}
			System.out.print("*");

			System.out.println();
		}
	}

	public static void printX(int shape_size) { // Creating a method for printing 'X'. Based on user's input. 

		for (int j = 0; j < shape_size; j++) {

			for (int i = 0; i < shape_size; i++) {

				if (i == j || i + j == shape_size - 1) {

					System.out.print("*");
				} else {

					System.out.print(" ");
				}

			}

			System.out.println();
		}

	}

	public static void printZ(int shape_size) { // Creating a method for printing 'Z'. Based on user's input.
		for (int j = 0; j < shape_size; j++) {

			for (int i = 0; i < shape_size; i++) {

				if (j == 0 || j == shape_size - 1) {

					System.out.print("*");

				} else {

					if (i + j == shape_size - 1) {

						System.out.print("*");

					} else {

						System.out.print(" ");
					}
				}

			}
			System.out.println();
		}
	}

}
