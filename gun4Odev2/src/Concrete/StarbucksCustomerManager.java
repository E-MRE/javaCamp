package Concrete;

import Abstract.BaseCustomerManager;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {
	 @Override
	    public void save(Customer customer) {

	        CustomerCheckManager customerCheckManager= new CustomerCheckManager();
	        if(customerCheckManager.mernisControl(customer)){
	            System.out.println(customer.getNationalId()+" numaralı kimliğiniz başarıyla doğrulanmıştır");
	            super.save(customer);
	        }else{
	            System.out.println("Kimlik numaranız hatalıdır!");
	        }

	    }
}
