package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerValidationService extends UserValidationService {
	
	boolean employerValid(Employer employer);
	boolean checkCompanyEmail(String email, String website);
	
}
