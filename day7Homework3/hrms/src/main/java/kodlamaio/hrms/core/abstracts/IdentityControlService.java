package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface IdentityControlService {
	boolean userValid(User user);
}
