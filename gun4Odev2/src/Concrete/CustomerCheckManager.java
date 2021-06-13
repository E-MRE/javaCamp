package Concrete;

import Abstract.CustomerCheckService;
import Adapters.MernisServiceAdapter;
import Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService {

	@Override
	public boolean mernisControl(Customer customer) {
		MernisServiceAdapter mernisServiceAdapter = new MernisServiceAdapter();
        return mernisServiceAdapter.mernisControl(customer);
	}

}
