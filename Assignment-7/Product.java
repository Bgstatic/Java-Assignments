

import java.util.*;

public class Product{
	

	private String productName;
	private Calendar saleDate;
	private double price;
	
	
	public Product(String sName , Calendar sDate , double price) { // Creating constructors from super class.
		
		this.productName = sName;
		this.saleDate = sDate;
		this.price = price;
	}

     //Creating getter and setter methods for all data fields.
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Calendar getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		
		int Saleday = saleDate.get(5) ;
		int Salemonth = saleDate.get(2) + 1;
		int Saleyear = saleDate.get(1); 
		return "Product [productName=" + productName + ", transactionDate=" + Saleday + "/" + Salemonth + "/" + Saleyear  + ", price=" + price + "]";
	}
	
	
}
