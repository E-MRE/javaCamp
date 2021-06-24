package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmployerValidationService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerValidationManager extends UserValidationManager implements EmployerValidationService {

	@Override
	public boolean employerValid(Employer employer) {
		boolean checkInfoFirst = employer.getCompanyName() != "" && employer.getPhone() != "" && employer.getWebsite() != "" && employer.getEmail() != "" && employer.getPassword() != "" && employer.getUserType().getUserType() != "";
		boolean checkInfoSecond = employer.getCompanyName() != null && employer.getPhone() != null && employer.getWebsite() != null && employer.getEmail() != null && employer.getPassword() != null && employer.getUserType().getUserType() != null;
		
		return checkInfoFirst && checkInfoSecond;
	}

	@Override
	public boolean checkCompanyEmail(String email, String website) {
		var splittedEmail = email.split("@");
		if(splittedEmail[1].contains(website))
			return true;
		
		return false;
	}

}
