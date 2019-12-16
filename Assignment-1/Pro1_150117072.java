import java.util.Scanner;
 
public class Pro1_150117072 {

	public static void main(String[] args) {
		//Bilgehan Gecici 150117072
       
		/*This program calculates perpendicular bisector of the line segment between two points in linear equation. 
		  Based on some x and y variables */
		
		//Creating a Scanner object in order to get input from user
		Scanner input = new Scanner(System.in);
		
		//Getting x1, y1, x2, y2 values from user
		System.out.print("Enter the value of x1: ");
		
		double x1 = input.nextDouble();
		
		System.out.print("Enter the value of y1: ");
		
		double y1 = input.nextDouble();
		
		System.out.print("Enter the value of x2: ");
		
		double x2 = input.nextDouble();
		
		System.out.print("Enter the value of y2: ");
		
		double y2 = input.nextDouble();
		
		//Finding slope 
		double slope = (y2 - y1) / (x2 - x1);
				
		//Finding midpoints
		double xmid = (x1 + x2) / 2;
		
		double ymid = (y1 + y2) / 2;
		
		//Finding the slope of the perpendicular bisector
		double perpendicular_slope = (- Math.pow(slope, -1));
		
		//Finding y intercept
		double y_intercept =  (ymid - (perpendicular_slope * xmid));
		
		//Printing all the values in y = mx + b format with if-else statement		
        if( y_intercept<0) {
		
        System.out.println("The equation of the perpendicular bisector of the line segment between " + 
        "(" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 +")" + " is " + 
        "y = " + perpendicular_slope + "x" + " - " + (-y_intercept));
	 
	    }else if(y_intercept>0) {
		  
	    System.out.println("The equation of the perpendicular bisector of the line segment between " 
	    + "(" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 +")" + " is " + 
	     "y = " + perpendicular_slope + "x" + " + " + (y_intercept));
	  
	    }
              
    }      

}
