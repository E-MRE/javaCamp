package day5Homework1.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import day5Homework1.business.abstracts.CheckUserService;
import day5Homework1.entities.concretes.User;

public class CheckUserManager implements CheckUserService {

	@Override
	public boolean checkNewEmail(String email, List<User> userList) {
		for(User user : userList) {
			if(user.getEmail() == email)
				return false;
		}
		
		return true;
	}

	@Override
	public boolean checkPassword(String password) {
		if(password.length() < 6)
			return false;
		else
			return true;
	}

	@Override
	public boolean isValidUser(User user) {
		if(user.getName().length() < 2 || user.getSurname().length() < 2 || user.getEmail().length() < 1)
			return false;
		
		return true;
	}

	@Override
	public boolean isValidEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
	}
	
	@Override
	public boolean isVerifiedUser(String email) {
		return true;
	}

}
