package inheritance;

public class CustomerManager {

	private Customer _customer;
	
	public CustomerManager() {
		
	}
	
	public CustomerManager(Customer customer) {
		_customer = customer;
	}
	
	public void add(Customer customer) {
		System.out.println(customer.getCustomerNumber() + " Eklendi");
	}
	
	public void addMultiple(Customer[] customers) {
		for(Customer customer : customers) {
			add(customer);
		}
	}
}
