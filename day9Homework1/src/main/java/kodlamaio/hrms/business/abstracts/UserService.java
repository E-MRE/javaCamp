package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface UserService {
	
	Result checkEmailVerified(String email);
	
	Result checkEmailAlreadyExist(String email);
	
	Result sendVerificationCode(String email, String verificationCode);
}
