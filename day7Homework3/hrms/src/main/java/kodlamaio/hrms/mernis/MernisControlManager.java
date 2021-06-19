package kodlamaio.hrms.mernis;

import kodlamaio.hrms.entities.concretes.User;

public class MernisControlManager {
	
	public boolean userVerified(User user) {
		if(user.getNationalIdentity().length() < 11)
			return false;
		
		return true;
	}
}
