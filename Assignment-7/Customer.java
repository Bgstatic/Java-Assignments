
import java.util.*;

public class Customer extends Person { //Customer Class.

	private ArrayList<Product> products;
	
	
	public Customer(int id, String firstName, String lastName, String gender, // Creating constructors from super class.
			Calendar birthDate, String maritalStatus,String hasDriverLicence, ArrayList<Product> products) throws Exception {
		
		super(id , firstName , lastName , gender , birthDate , maritalStatus , hasDriverLicence );
		
		this.setProducts(products);
	}
	
	public Customer( Person person, ArrayList<Product>  products) throws Exception { // Creating overloaded constructors from super class.
		
		super.setId(person.getId());
		super.setFirstName(person.getFirstName());
		super.setLastName(person.getLastName());
		super.setGender(person.getGender());
		super.setBirthdate(person.getBirthdate());
		super.setMaritalStatus(person.getMaritalStatus());
		super.setHasDriverLicense(person.getHasDriverLicense());
		this.products = products;
	}

	// Creating getter and setter methods for all data fields.
	public ArrayList<Product> getProducts() {
		
		return products;
		
	}

	public void setProducts(ArrayList<Product> products) {
		
		this.products = products;
		
	}

	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		return "Customer [id="+ super.getId() + " " + "products=" + products + "]";
	}
	
	
}
