package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerValidationService {
	
	boolean employerValid(Employer employer);
	boolean checkEmailFormat(String email);
	boolean checkCompanyEmail(String email, String website);
	
}
