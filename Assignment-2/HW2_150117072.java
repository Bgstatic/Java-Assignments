package myjavaprograms;

import java.util.Scanner;

public class HW2_150117072 {

	public static void main(String[] args) {
		//Bilgehan Geçici 150117072
		// This program calculates your car price including taxes and some extra packages which is based on your choices.
     
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Marmara Motor Cars");
		System.out.println("------------------------------");
		System.out.println("Compact (C) ");
		System.out.println("Luxury (L) ");
		System.out.println("Midsize (M) ");
		System.out.println("Pickup (P) ");
		System.out.println("SUV (S) ");
		
		
        System.out.print("What model of car do you want? (C, L, M, P, S): ");
        String car_type = input.nextLine();

        String answer_protective;  // Create a string variable to get answer for protective undercoating package
        String answer_security;  // Create a string variable to get answer for security package
        String answer_multimedia; // Create a string variable to get answer for multimedia package
        String answer_sunroof; // Create a string variable to get answer for sunroof option
        String answer_transmission; // Create a string variable to get answer for automatic transmission option
        String answer_sports; // Create a string variable to get answer for sports package 
        double Additional_Package_Cost = 0;
        double Compact_Price = 16000.0; // Compact car price 
        double Luxury_Price = 39000.0;  // Luxury car price
        double Pickup_Price = 19500.0; // Pickup car price
        double SUV_Price = 29000.0; // SUV car price 
        double Midsize_Price = 26000.0; // Mid-size car price      
    	double Total_Cost; // Final price for all cars
        double SalesTax;  //  This is a variable for car's sales tax
        
        switch(car_type.toUpperCase()) { // Owing to .toUpperCase() function, we can also write in small letters
        
        case "C": 
        	 
            System.out.print("Do you want protective undercoating for $125.0 (Y/N)?");
        	answer_protective = input.nextLine();
        	
        	if(answer_protective.equalsIgnoreCase("Y")) { /* if the user selects protective undercoating package,
        	                                              then additional cost will rise for $125.0 */       	     
        		Additional_Package_Cost+= 125.0;
        	} 
        	       	
        	System.out.print("Do you want the security package for $800.0 (Y/N)?"); 
                                                                                    
        	answer_security = input.nextLine();
        	
        	if(answer_security.equalsIgnoreCase("Y")) { /* if the user selects security
                                                        package, then additional cost will rise for $800.0 */
        	
        		Additional_Package_Cost+= 800.0;
        	}	
        	    // Evaluating the final price for compact car including taxes
        		Total_Cost = Additional_Package_Cost + Compact_Price;  
        		SalesTax = (Total_Cost * 35) / 100 + ((Total_Cost + (Total_Cost * 35) / 100)) * 18 / 100; 
        		
        		//Printing final results for compact car
        		System.out.println();
        		System.out.println("You ordered a Compact car with a base price of $16000.0");
        		System.out.println("Your additional cost is: " + Additional_Package_Cost);
        		System.out.println("Sales Tax: " + "$" + SalesTax);
        		System.out.println("Total cost of car & options: " + "$" + (SalesTax + Total_Cost));
        		System.out.println("Program ends ...");
        break;
        
        case "P":
        
             System.out.print("Do you want protective undercoating for $150.0 (Y/N)?");
    	     answer_protective = input.nextLine();
    	
    	if(answer_protective.equalsIgnoreCase("Y")) { /* if the user selects protective undercoating package,
                                                      then additional cost will rise for $150.0 */       	       
    		  Additional_Package_Cost+= 150.0;
    	} 
    	       	
    	     System.out.print("Do you want the multimedia package for $750.0 (Y/N)?");
    	     answer_multimedia = input.nextLine();
    	
    	if(answer_multimedia.equalsIgnoreCase("Y")) { /* if the user selects multimedia package,
                                                      then additional cost will rise for $750.0 */       	     	
    		     Additional_Package_Cost+= 750.0;
    	}	
    	          // Evaluating the final price for pickup car including taxes
    		      Total_Cost = Additional_Package_Cost + Pickup_Price;
    		      SalesTax = (Total_Cost * 35) / 100 + ((Total_Cost + (Total_Cost * 35) / 100)) * 18 / 100;
    		      
    		      //Printing final result for pickup car 
    		      System.out.println();
    		      System.out.println("You ordered a Pickup car with a base price of $19500.0");
    		      System.out.println("Your additional cost is: " + Additional_Package_Cost);
    		      System.out.println("Sales Tax: " + "$" + SalesTax);
    		      System.out.println("Total cost of car & options: " + "$" + (SalesTax + Total_Cost)); 
    		      System.out.println("Program ends ...");
         break;  
         
         case "L":	      
    		     
             System.out.print("Do you want protective undercoating for $125.0 (Y/N)?");
             answer_protective = input.nextLine();
        	
        	if(answer_protective.equalsIgnoreCase("Y")) { /* if the user selects protective undercoating package,
                                                          then additional cost will rise for $125.0 */    	     
        		Additional_Package_Cost+= 125.0;
        	} 
        	       	
        	 System.out.print("Do you want the multimedia package for $1250.0 (Y/N)?"); 
        	 answer_multimedia = input.nextLine();
        	
        	if(answer_multimedia.equalsIgnoreCase("Y")) { /* if the user selects multimedia package,
                                                         then additional cost will rise for $1250.0 */
        	    Additional_Package_Cost+= 1250.0;
        		     
        	}	     
        	
        	if(answer_protective.equalsIgnoreCase("Y") && answer_multimedia.equalsIgnoreCase("Y")) { /* If user selects both protective undercoating
        	                                                                                         and multimedia package, then additional cost will
        	                                                                                         decrease about %5 */       		
        		Additional_Package_Cost = (Additional_Package_Cost - (Additional_Package_Cost * 5) / 100);
        	}       
        	         // Evaluating the final price for pickup car including taxes
        		     Total_Cost = Additional_Package_Cost + Luxury_Price;
        		     SalesTax = (Total_Cost * 40) / 100 + ((Total_Cost + (Total_Cost * 40) / 100)) * 18 / 100;
        		      
        		   //Printing final results for luxury car 
        		   System.out.println();
        		   System.out.println("You ordered a Luxury car with a base price of $39000.0");
                   System.out.println("Your additional cost is: " + Additional_Package_Cost);
        	       System.out.println("Sales Tax: " + "$" + SalesTax);
        	       System.out.println("Total cost of car & options: " + "$" + (SalesTax + Total_Cost));
        	       System.out.println("Program ends ...");
           break;
           
           case "S":
        	 
        	 System.out.print("Do you want protective undercoating for $200.0 (Y/N)? "); 
        	 answer_protective = input.nextLine();
        	 
        	 if(answer_protective.equalsIgnoreCase("Y")) { /* if the user selects protective undercoating package,
                                                           then additional cost will rise for $200.0 */    	            		 
        		 Additional_Package_Cost +=200.0;
        	 }
        	 
        	 System.out.print("Do you like to replace the normal transmission by an automatic transmission for $2500.0 (Y/N)? ");
             answer_transmission = input.nextLine();
        	 
        	 if(answer_transmission.equalsIgnoreCase("Y")) { /* if the user selects automatic transmission package,
                                                               then additional cost will rise for $2500.0 */    	     
        		 Additional_Package_Cost +=2500.0;
        	 }
        	 
        	 System.out.print("Do you want sunroof for $2300.0 (Y/N)? ");
        	 answer_sunroof = input.nextLine();
        	 
              if(answer_sunroof.equalsIgnoreCase("Y")) {  /* if the user selects sunroof package, then 
                                                          additional cost will rise for $2300.0 */    	           		 
        		 Additional_Package_Cost +=2300.0;
        	 }
              
             System.out.print("Do you want the multimedia package for $1000.0 (Y/N)? "); 
             answer_multimedia = input.nextLine();
        	 
             if(answer_multimedia.equalsIgnoreCase("Y")) {  /* if the user selects multimedia package, then 
                                                            additional cost will rise for $1000.0 */       		 
       		    Additional_Package_Cost +=1000.0;      		 
       	    }
              
             System.out.print("Do you want the security package for $1350.0 (Y/N)? "); 
             answer_security = input.nextLine();
        	 
             if(answer_security.equalsIgnoreCase("Y")) { /* if the user selects security package, then 
                                                         additional cost will rise for $1350.0 */      		 
       		   Additional_Package_Cost +=1350.0;
       	    }             
             System.out.print("Do you want the sports package for an increased 5.0% This will increase your cost by $1450.0 (Y/N)? "); 		 
             answer_sports = input.nextLine();
             
             if(answer_sports.equalsIgnoreCase("Y")) {  /* if the user selects sport package, then 
                                                       additional cost will rise for $1450.0 */          	 
       		   Additional_Package_Cost +=1450.0;       		  
            }                       
             
             if(answer_security.equalsIgnoreCase("Y") && answer_multimedia.equalsIgnoreCase("Y") &&  
                answer_sunroof.equalsIgnoreCase("Y") && answer_transmission.equalsIgnoreCase("Y")) { /* if user selects security, multimedia, sunroof
                                                                                                      and transmission package at same time, then the user 
                                                                                                      get the protective undercoating package for free */      	 
            	 System.out.println("You won protective undercoating for free! "); 
            	       	 
             }
              // Evaluating the final price for SUV car including taxes
             Total_Cost = Additional_Package_Cost + SUV_Price;
      	           	     
      	     if(Total_Cost < 35000.0) { /* if the suv car's total price is less than $35000.0, 
      	    	                        then the %35 ötv will be applied including %18 kdv */
      	    	 
      	     SalesTax = (Total_Cost * 35) / 100 + ((Total_Cost + (Total_Cost * 35) / 100)) * 18 / 100; 
      	     
      	     System.out.println();
		     System.out.println("You ordered a SUV car with a base price of $29000.0");
		     System.out.println("Your additional cost is: " + "$" + Additional_Package_Cost);
		     System.out.println("Sales Tax: " + "$" + SalesTax);
		     System.out.println("Total cost of car & options: " + "$" + (SalesTax + Total_Cost));
		     System.out.println("Program ends ...");
      	     }
      	     else if(Total_Cost >= 35000.0) { /* if the suv car's total price is greater or equal than $35000.0, 
                                                then the %40 ötv will be applied including %18 kdv */
      	    	 
      	     SalesTax = (Total_Cost * 40) / 100 + ((Total_Cost + (Total_Cost * 40) / 100)) * 18 / 100;
      	     
      	     System.out.println();
		     System.out.println("You ordered a SUV car with a base price of $29000.0");
		     System.out.println("Your additional cost is: " + "$" + Additional_Package_Cost);
		     System.out.println("Sales Tax: " + "$" + SalesTax);
		     System.out.println("Total cost of car & options: " + "$" + (SalesTax + Total_Cost));
		     System.out.println("Program ends ...");
      	     }
      	     
           break; 
           
           case "M":
        	   
        	   System.out.print("Do you want protective undercoating for $125.0 (Y/N)? ");
          	   answer_protective = input.nextLine();
          	 
          	   if(answer_protective.equalsIgnoreCase("Y")) { /* if the user selects protective undercoating package, then 
                                                             additional cost will rise for $125.0 */    		 
          		 Additional_Package_Cost +=125.0;
          	 }
        	   
          	 System.out.print("Do you like to replace the normal transmission by an automatic transmission for $2000.0 (Y/N)? ");
             answer_transmission = input.nextLine();
        	 
        	 if(answer_transmission.equalsIgnoreCase("Y")) { /* if the user selects automatic transmission package, then 
                                                              additional cost will rise for $2000.0 */        		 
        		 Additional_Package_Cost +=2000.0;
        	 }
        	 
        	 System.out.print("Do you want sunroof for $1500.0 (Y/N)? ");
        	 answer_sunroof = input.nextLine();
        	 
              if(answer_sunroof.equalsIgnoreCase("Y")) { /* if the user selects sunroof package, then 
                                                         additional cost will rise for $1500.0 */        		 
        		 Additional_Package_Cost +=1500.0;
        	 }
              
             System.out.print("Do you want the multimedia package for $750.0 (Y/N)? "); 
             answer_multimedia = input.nextLine();
        	 
             if(answer_multimedia.equalsIgnoreCase("Y")) { /* if the user selects multimedia package, then 
                                                           additional cost will rise for $750.0 */     		 
       		     Additional_Package_Cost +=750.0;      		 
       	    }
              
             System.out.print("Do you want the security package for $1000.0 (Y/N)? "); 
             answer_security = input.nextLine();
        	 
             if(answer_security.equalsIgnoreCase("Y")) { /* if the user selects security package, then 
                                                         additional cost will rise for $1000.0 */      		 
       		     Additional_Package_Cost +=1000.0;
       	    }     
             
             System.out.print("Do you want the sports package for an increased 5.0% This will increase your cost by $1300.0 (Y/N)? "); 		 
             answer_sports = input.nextLine();
                  
             if(answer_sports.equalsIgnoreCase("Y")) { /* if the user selects sports package, then 
                                                       additional cost will rise for $1300.0 */           	 
       		    Additional_Package_Cost +=1300.0;       		  
            }                       
      	     
             if(answer_sunroof.equalsIgnoreCase("Y") && answer_multimedia.equalsIgnoreCase("Y")) { /* If a customer selects sunroof with multimedia package 
            	                                                                                  then the total cost of these packages will be decreased to $2000. */ 
            	 Additional_Package_Cost -= 250.0;
             }
             
             if(answer_security.equalsIgnoreCase("Y") && answer_transmission.equalsIgnoreCase("Y")) { /*If a customer selects security package with automatic transmission, 
            	                                                                                      then, apply 10% discount to the total cost of these packages. */ 
            	Additional_Package_Cost -= 300;
             }
              // Evaluating the final price for Midsize car including taxes
             Total_Cost = Additional_Package_Cost + Midsize_Price;
         	     
      	     if(Total_Cost < 35000.0) { /* if the midsize car's total price is less than $35000.0, 
                                          then the %35 ötv will be applied including %18 kdv */ 
      	    	 
      	     SalesTax = (Total_Cost * 35) / 100 + ((Total_Cost + (Total_Cost * 35) / 100)) * 18 / 100; 
      	     
      	     System.out.println();
		     System.out.println("You ordered a Midsize car with a base price of $26000.0");
		     System.out.println("Your additional cost is: " + "$" + Additional_Package_Cost);
		     System.out.println("Sales Tax: " + "$" + SalesTax);
		     System.out.println("Total cost of car & options: " + "$" + (SalesTax + Total_Cost));
		     System.out.println("Program ends ...");
      	     }
      	     else if(Total_Cost >= 35000.0) { /* if the midsize car's total price is equal or greater than $35000.0, 
                                              then the %40 ötv will be applied including %18 kdv */  
      	    	 
      	     SalesTax = (Total_Cost * 40) / 100 + ((Total_Cost + (Total_Cost * 40) / 100)) * 18 / 100;
      	     
      	     System.out.println();
		     System.out.println("You ordered a Midsize car with a base price of $26000.0");
		     System.out.println("Your additional cost is: " + "$" + Additional_Package_Cost);
		     System.out.println("Sales Tax: " + "$" + SalesTax);
		     System.out.println("Total cost of car & options: " + "$" + (SalesTax + Total_Cost));
		     System.out.println("Program ends ...");
      	     }
         
         break;                        
      }	                           
	} 
 }
