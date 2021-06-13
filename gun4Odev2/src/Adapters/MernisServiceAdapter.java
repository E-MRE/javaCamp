package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;

public class MernisServiceAdapter implements CustomerCheckService {
	@Override
    public boolean mernisControl(Customer customer) {
        return true;
    }
}
