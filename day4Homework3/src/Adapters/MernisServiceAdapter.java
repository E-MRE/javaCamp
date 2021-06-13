package Adapters;

import Abstract.UserCheckService;
import Entity.User;

public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkUser(User user) {
		if(user.getName() == "" || user.getNationalIdentity() == "")
			return false;
		else
			return true;
	}

}
