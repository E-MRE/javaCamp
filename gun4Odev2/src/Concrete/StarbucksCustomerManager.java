package Concrete;

import Abstract.BaseCustomerManager;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {
	 @Override
	    public void save(Customer customer) {

	        CustomerCheckManager customerCheckManager= new CustomerCheckManager();
	        if(customerCheckManager.mernisControl(customer)){
	            System.out.println(customer.getNationalId()+" numaral� kimli�iniz ba�ar�yla do�rulanm��t�r");
	            super.save(customer);
	        }else{
	            System.out.println("Kimlik numaran�z hatal�d�r!");
	        }

	    }
}
