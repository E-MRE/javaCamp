package kodlamaio.hrms.core.concretes;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.UserValidationService;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserValidationManager implements UserValidationService {

	@Override
	public boolean userInfoValid(User user) {
		boolean checkInfoFirst = user.getName() != "" && user.getNationalIdentity() != "" && user.getSurname() != "" && user.getEmail() != "" && user.getPassword() != "";
		boolean checkInfoSecond = user.getName() != null && user.getNationalIdentity() != null && user.getSurname() != null && user.getEmail() != null && user.getPassword() != null;
		
		return checkInfoFirst && checkInfoSecond;
	}

	@Override
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
