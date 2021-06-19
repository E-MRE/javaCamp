package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.IdentityControlService;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.mernis.MernisControlManager;

@Service
public class MernisControlAdapter implements IdentityControlService {

	@Override
	public boolean userValid(User user) {
		MernisControlManager mernisManager = new MernisControlManager();
		return mernisManager.userVerified(user);
	}

}
