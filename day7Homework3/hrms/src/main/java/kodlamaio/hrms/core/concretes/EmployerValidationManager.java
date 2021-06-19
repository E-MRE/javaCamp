package kodlamaio.hrms.core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmployerValidationService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerValidationManager implements EmployerValidationService {

	@Override
	public boolean employerValid(Employer employer) {
		boolean checkInfoFirst = employer.getCompanyName() != "" && employer.getEmail() != "" && employer.getPassword() != "" && employer.getPhone() != "" && employer.getWebsite() != "";
		boolean checkInfoSecond = employer.getCompanyName() != null && employer.getEmail() != null && employer.getPassword() != null && employer.getPhone() != null && employer.getWebsite() != null;
		
		return checkInfoFirst && checkInfoSecond;
	}

	@Override
	public boolean checkEmailFormat(String email) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		
		if(!(matcher.find())) 
			return false;
		
		return true;
	}

	@Override
	public boolean checkCompanyEmail(String email, String website) {
		var splittedEmail = email.split("@");
		if(splittedEmail[1].contains(website))
			return true;
		
		return false;
	}

}
