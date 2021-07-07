package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmployerValidationService;
import kodlamaio.hrms.core.utilities.Validation;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerValidationManager implements EmployerValidationService {

	@Override
	public boolean employerValid(Employer employer) {
		return !(Validation.stringsIsNullOrEmpty(employer.getCompanyName(), employer.getPhone(), employer.getWebsite(), employer.getUser().getEmail(), 
				employer.getUser().getPassword(), employer.getUser().getUserType().getUserType()));
	}

	@Override
	public boolean checkCompanyEmail(String email, String website) {
		var splittedEmail = email.split("@");
		if(splittedEmail[1].contains(website))
			return true;
		
		return false;
	}

}
