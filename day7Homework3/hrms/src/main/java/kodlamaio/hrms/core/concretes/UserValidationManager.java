package kodlamaio.hrms.core.concretes;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.UserValidationService;

@Service
public class UserValidationManager implements UserValidationService {

	public boolean emailFormatValid(String email) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		
		if(!(matcher.find())) {
			return false;
		}
		else {
			return true;
		}	
	}
}
