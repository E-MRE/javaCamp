package day5Homework1.core.concretes;

import day5Homework1.Google.GoogleUserManager;
import day5Homework1.business.abstracts.CheckUserService;
import day5Homework1.core.abstracts.GoogleService;

public class GoogleManagerAdapter implements GoogleService {

	private CheckUserService checkUserService;
	private GoogleUserManager googleManager;
	
	public GoogleManagerAdapter(CheckUserService checkUserService) {
		this.checkUserService = checkUserService;
		googleManager = new GoogleUserManager();
	}

	@Override
	public void registerToSystem(String email, String password) {
		if(email == "" || password == "") {
			System.out.println("Hatal� eposta ya da �ifre girdiniz");
		}
		else if(!checkUserService.checkPassword(password)) {
			System.out.println("Parola en az 6 karakter olmal�d�r.");
		}else if(!checkUserService.isValidEmail(email)) {
			System.out.println("Hatal� e-posta");
		}else {
			googleManager.register(email, password);
		}
		
	}

	@Override
	public void loginToSystem(String email, String password) {
		
		if(email == "" || password == "") {
			System.out.println("Hatal� eposta ya da �ifre girdiniz");
		}else {
			googleManager.login(email, password);
		}
	}

}
