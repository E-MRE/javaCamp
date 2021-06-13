package gun4Odev2;

//import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		Customer ali = new Customer(1,"Ali","Er","01/01/1980","123456");

        //BaseCustomerManager baseCustomerManager= new StarbucksCustomerManager();
        StarbucksCustomerManager starbucksCustomerManager = new StarbucksCustomerManager();
        //NeroCustomerManager neroCustomerManager = new NeroCustomerManager();
        starbucksCustomerManager.save(ali);
        //neroCustomerManager.save(ali);
        //baseCustomerManager.save(ali);

	}

}
