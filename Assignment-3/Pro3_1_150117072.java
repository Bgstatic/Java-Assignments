

import java.util.Scanner;

public class Pro3_1_150117072 {

	public static void main(String[] args) {
		// Bilgehan Ge�ici 150117072
		
		//This program prints some specific characters based on your sequence which is a string value.
				
		Scanner input = new Scanner(System.in); // Creating a scanner object in order to get input from user.
		
		System.out.println("Welcome to image printer program");
		
		System.out.print("Please enter your sequence: ");
		
		String sequence = input.next(); // Getting the sequence from user in string type. 
		
	

		for (int i = 0; i < sequence.length(); i++) { /* Creating a loop body to limit the print execution  
			                                        where the sequence is over . */ 

			if (Character.isDigit(sequence.charAt(i))) { /* This 'if-else statement' checks  the user's sequence if it
			                                             contains any number. If it has any number, then it prints characters  
			                                             based on it's number. For an example if sequence contains the number 2 which  
			                                             means the specific character will be printed 2 times.*/

				int digit = sequence.charAt(i) - 48; /* Converting the sequence's numbers from string variable 
				                                     to integer value. In other words we get the numbers from the sequence. */
				
				// int digit = Integer.parseInt(String.valueOf(sequence.charAt(i))); ---> We can also use it for converting process. 

				for (int k = 0; k < digit; k++) { 

					char currentChar = sequence.charAt(i + 1); /*  For this section we took the number with sequence.charAt(i). Now we take the specific
					                                           character with .charAt(i+1). Because after the every number there has to be 
					                                           at least one specific character. */
					
					printCharByCondition(currentChar);

				}

				i++;

			} else { // if sequence has no any number, then prints specific characters one time.

				char currentChar = sequence.charAt(i);
				
				printCharByCondition(currentChar);
			}

		}
	}

	public static void printCharByCondition(int currentChar) { /* Creating a method for printing specific characters 
                                                                 based on the user's sequence. */		
		if (currentChar == 'b') {                               

			System.out.print(" ");

		} else if (currentChar == 'n') {
			
			System.out.println();

		} else if (currentChar == 's') {
			
			System.out.print("*");

		}
	}
			
}
