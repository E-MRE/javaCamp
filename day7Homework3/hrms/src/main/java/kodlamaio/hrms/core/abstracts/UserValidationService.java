package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface UserValidationService {
	boolean userInfoValid(User user);
	boolean emailFormatValid(String email);
}
