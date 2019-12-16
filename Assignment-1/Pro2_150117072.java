
import java.util.Scanner;

public class Pro2_150117072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Bilgehan Ge�ici 150117072
		
				//This program calculates your retirement salary. Based on your monthly salary and some interest rates.
		        
				//Creating Scanner object in order to get input from user
				Scanner input = new Scanner(System.in);
				
				//Getting monthly salary from user
				System.out.print("Enter your monthly salary, for example 3500: ");
				
			    int TotalSalary = input.nextInt();
			    
			    //Getting percentage of salary from user 
			    System.out.print("Enter the percent of your salary to save, for example 10%: ");
			       
			    double Percentage = input.nextDouble();
			    
			    //Getting monthly interest rate from user 
			    System.out.print("Enter the monthly interest rate, for example 8.25%: ");
			    
			    double MonthlyInterestRate = input.nextDouble();
			    
			    //Getting government support rate from user
			    System.out.print("Enter the monthly government support rate, for example 25%: ");
			    
			    double GovernmentSupportRate = input.nextDouble();
			    
			    //Finding monthly saved money
			    double MonthlySavedMoney = (TotalSalary * Percentage) / 100;
			    
			    //Finding total saved money
			    double TotalSavedMoney = (6 * MonthlySavedMoney);
			    
			    //It helps to read the outputs more easily
			    System.out.println("");
			    	   
			   //Finding monthly incomes and executing casting process
			   double FirstMonth =  (MonthlySavedMoney * (1 + GovernmentSupportRate/100) * (1 + MonthlyInterestRate/100));
			   double SecondMonth = (FirstMonth + MonthlySavedMoney * (1 + GovernmentSupportRate/100)) * (1 + MonthlyInterestRate/100);
			   double ThirdMonth =  (SecondMonth + MonthlySavedMoney * (1 + GovernmentSupportRate/100)) * (1 + MonthlyInterestRate/100);
			   double FourthMonth = (ThirdMonth + MonthlySavedMoney * (1 + GovernmentSupportRate/100)) * (1 + MonthlyInterestRate/100);
			   double FifthMonth =  (FourthMonth + MonthlySavedMoney * (1 + GovernmentSupportRate/100)) * (1 + MonthlyInterestRate/100);
			   double SixthMonth =  (FifthMonth +  MonthlySavedMoney * (1 + GovernmentSupportRate/100)) * (1 + MonthlyInterestRate/100);
			   
			   //Finding total profit 
			   double TotalProfit = (SixthMonth - TotalSavedMoney);
			   
			   //Printing monthly incomes with casting execution
			   System.out.println("After the first month, the account value is: " + (int)(FirstMonth * 100) / 100.0);
			   System.out.println("After the second month, the account value is: " + (int)(SecondMonth * 100) / 100.0);
			   System.out.println("After the third month, the account value is: " + (int)(ThirdMonth * 100) / 100.0);
			   System.out.println("After the fourth month, the account value is: " +(int)(FourthMonth * 100) / 100.0);
			   System.out.println("After the fifth month, the account value is: " + (int)(FifthMonth * 100) / 100.0);
			   System.out.println("After the sixth month, the account value is: " + (int)(SixthMonth * 100) / 100.0);
			   
			   //Printing final results with casting execution 
			   System.out.println("In total, you saved " + TotalSavedMoney + " TL" + " and your total profit is " + (int)(TotalProfit * 100) / 100.0 + " TL");
			}
	}


