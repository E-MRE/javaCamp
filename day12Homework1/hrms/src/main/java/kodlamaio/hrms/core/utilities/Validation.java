package kodlamaio.hrms.core.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	public static boolean stringsIsNullOrEmpty(String...  values) {
		for(String value : values) {
			if(value == null || value.equals("")) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean emailFormatValid(String email) {
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
