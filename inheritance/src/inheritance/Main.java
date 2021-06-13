package inheritance;

public class Main {

	public static void main(String[] args) {
		
		IndividualCustomer individual = new IndividualCustomer();
		individual.setCustomerNumber("10000");
		
		CorporateCustomer corporate = new CorporateCustomer();
		corporate.setCustomerNumber("544445");
		
		SendikaCustomer sendika = new SendikaCustomer();
		sendika.setCustomerNumber("225488");
		
		CustomerManager customerManager = new CustomerManager();
		customerManager.addMultiple(new Customer[] {sendika,individual,corporate});
	}

}
