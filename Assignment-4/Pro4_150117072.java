

import java.util.Scanner;

public class Pro4_150117072 {

	public static void main(String[] args) {

		// Bilgehan Ge�ici 150117072
		/* This program analysis the string in many ways. This program also do some executions on string. 
		   These are: Count number of chars in given string, print the words in a sentence, delete substring in given string,
		   replace substring in given string, sort characters in given string and finally the program calculates 
		   the hash code of a given string. The string is given by the user. */
		 

		Scanner input = new Scanner(System.in); // Creating a scanner object to get input from user.

		System.out.println("Welcome to our String Analyzer Program.");

		boolean isContinue = true; // Creating a boolean variable for restart all the execution.
		String str = ""; // This string variable is needed for all off the execution.
		char ch; // This char variable is necessary for count number of chars in given string.
		String subStr = ""; // This string variable is needed for the third execution.
		int type = 0; /* Some of the executions has two ways the interact with string. This variable
				      defines the type of execution. */ 
		int b = 0; // This integer variable is for hash code execution.
		String subStr1 = ""; // This variable is for replacing execution.
		String subStr2 = ""; // This variable is also for replacing execution.
		String menu_choice = ""; // With this variable, the user can select the execution type.

		while (isContinue) { // if the boolean variable is true, then the all of the execution starts again.

			System.out.println();

			System.out.println("1. Count number of chars");
			System.out.println("2. Print the words in a sentence");
			System.out.println("3. Delete substring");
			System.out.println("4. Replace substring");
			System.out.println("5. Sort characters");
			System.out.println("6. Hash code of a string");

			System.out.print("Please enter your menu choice: ");
			menu_choice = input.nextLine(); // Getting menu choice information from the user.

			if (menu_choice.equalsIgnoreCase("quit")
					|| menu_choice.equalsIgnoreCase("exit")) { /* If the user enters the menu choice as 'quit or 'exit,
																  then program shuts down. */
																

				System.out.println("Program ends. Bye :) ");

				System.exit(0);
			}

			switch ((menu_choice)) { // With switch statement all of the executions classifies by their number.

			case "1": // Count number of chars.

				System.out.print("Enter an input string: ");
				str = input.nextLine(); // Getting the string from user.

				System.out.print("Enter an input char: ");
				ch = input.nextLine().charAt(0); // Getting the character from user.

				// Displaying number of chars in user's string.
				System.out.println("The number of " + ch + " in " + str + " is " + numOfChars(str, ch));

				break;

			case "2": // Print the words in a sentence.

				System.out.print("Enter an input string: ");
				str = input.nextLine(); // Getting the string from user.

				// Printing the words in a sentence.
				System.out.println("The output is: ");
				printWords(str);

				break;

			case "3": // Delete substring.

				System.out.print("Enter an input string: ");
				str = input.nextLine(); // Getting the string from user.

				System.out.print("Enter a substring: ");
				subStr = input.nextLine(); // Getting the substring from user's string.

				System.out.print("Enter a type: ");
				type = Integer.parseInt(input.nextLine()); // Getting the type of execution from user.

				// Displaying the string with deleted substring version.
				System.out.println(delete(str, subStr, type));

				break;

			case "4": // Replace substring.

				System.out.print("Enter an input string: ");
				str = input.nextLine(); // Getting the string from user.

				System.out.print("Enter the first substring: ");
				subStr1 = input.nextLine(); // Getting the first substring from user's string.

				System.out.print("Enter the second substring: ");
				subStr2 = input.nextLine(); // Getting the second substring from user.

				System.out.println(replace(str, subStr1, subStr2));

				break;

			case "5": // Sort characters.

				System.out.print("Enter an input string: ");
				str = input.nextLine(); // Getting the string from user.

				System.out.print("Enter a type: ");
				type = Integer.parseInt(input.nextLine()); // Getting the type of execution from user.

				// Displaying sorted characters.
				sortChars(str, type);

				break;

			case "6": // Hash code of a string.

				System.out.print("Enter an input string: ");
				str = input.nextLine(); // Getting the string from user.

				System.out.print("Enter a value for b: ");
				b = Integer.parseInt(input.nextLine()); // Getting the integer value for hash code execution.

				// Displaying hash code value of a string.
				System.out.println("The hash code for " + str + " is " + hashCode(str, b));

				break;

			}

		}

	}

	public static int numOfChars(String str, char ch) {

		int count = 0;

		for (int i = 0; i < str.length(); i++) {

			if (ch == str.charAt(i)) { /* If the user's character is equal the user's string's character, then
										  increment the count value by one. */
										 
				count++;
			}

		}
		return count;

	}

	public static void printWords(String str) {

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == ' ' || str.charAt(i) == '-') { /*if the user's string's characters contains blank character 
				                                                 or hyphen print the character to the next line.*/

				System.out.println();

			} else if (str.charAt(i) == '!' || str.charAt(i) == ',' || str.charAt(i) == '.' || str.charAt(i) == '?' /* If the user's string's characters contains 
			                                                                                                         specific character, then the program doesn't print them. */
		    || str.charAt(i) == '_' || str.charAt(i) == '(' || str.charAt(i) == ')') {

			}

			else {

				System.out.print(str.charAt(i));
			}

		}

	}

	public static String delete(String str, String subStr, int type) {

		int index = str.indexOf(subStr); //Getting index number of the user's string's substring.

		while (index > -1) { // The execution continues when the index is not found in user's string.		
			
			if(type == 1) {
				
			str = str.substring(0, index) + str.substring(index + subStr.length());
			index = str.indexOf(subStr);
			
		}
			if (type == 0) { /* If type is 0 then the while loop breaks and the program only deletes the substring where
				             the substring occurs first time in string. */ 
				break;
			}

		}

		return str;
	}

	public static String replace(String str, String subStr1, String subStr2) {

		int index = str.indexOf(subStr1); // Getting index number of first substring to replace execution

		while (index > -1) { // The execution continues when the index is not found in user's string.

			str = str.substring(0, index) + subStr2 + str.substring(index + subStr1.length());
			index = str.indexOf(subStr1);
		}
		return str;
	}

	public static void sortChars(String str, int type) {

		int[] mylist = new int[str.length()]; //Creating an array with size of user's string length.

		if (type == 0) { /* When the type equals 0, then the program sorts the character of the user's string 
			                 in order of ASCII value from low to high and return the new string. */ 
			for (int i = 0; i < str.length(); i++) {

				mylist[i] = (int) (str.charAt(i));

			}
			SortArray(mylist);
			printArray(mylist);

		} else if (type == 1) { /* When the type equals 1, then the program sort the characters of the string in this order: 
		                the lower-case letters, the upper-case letters, the digits and the other characters */

			for (int i = 0; i < str.length(); i++) {

				if (Character.isLowerCase(str.charAt(i))) // Checking lower case letter from user's string and print it.
					System.out.print(str.charAt(i));

			}
			for (int i = 0; i < str.length(); i++) {

				if (Character.isUpperCase(str.charAt(i))) // Checking upper case letter from user's string and print it.
					System.out.print(str.charAt(i));

			}
			for (int i = 0; i < str.length(); i++) {

				if (Character.isDigit(str.charAt(i))) // Checking digit from user's string and print it.
					System.out.print(str.charAt(i));

			}
			for (int i = 0; i < str.length(); i++) {

				if (!Character.isLetterOrDigit(str.charAt(i))) // Checking special letters from user's string and print it.
					System.out.print(str.charAt(i));

			}

		}

	}

	public static void SortArray(int[] mylist) { //Sorting the array

		int mylist_size = mylist.length;
		int temp = 0;

		for (int i = 0; i < mylist_size; i++) {
			for (int j = 1; j < (mylist_size - i); j++) {

				if (mylist[j - 1] > mylist[j]) {

					temp = mylist[j - 1];
					mylist[j - 1] = mylist[j];
					mylist[j] = temp;
				}

			}
		}
	}

	public static void printArray(int[] mylist) { //Printing arrays in terms of characters
		for (int i = 0; i < mylist.length; i++)
			System.out.print((char) mylist[i]);
	}

	public static int hashCode(String str, int b) { 
		int sum = 0; 

		for (int i = 0; i < str.length(); i++) {

			sum += (int) (str.charAt(i)) * (int) Math.pow(b, str.length() - i - 1); // Hash code formula based on user's string.

		}
		return sum;
	}

}
