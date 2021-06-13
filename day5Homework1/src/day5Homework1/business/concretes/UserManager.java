package day5Homework1.business.concretes;

import java.util.List;

import day5Homework1.business.abstracts.CheckUserService;
import day5Homework1.business.abstracts.UserService;
import day5Homework1.dataAccess.abstracts.UserDao;
import day5Homework1.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private CheckUserService checkUserService;
	
	public UserManager(UserDao userDao, CheckUserService checkUserService) {
		this.userDao = userDao;
		this.checkUserService = checkUserService;
	}

	@Override
	public void register(User user) {
		if(!checkUserService.isValidUser(user)) {
			System.out.println("Hatalý kullanýcý");
		}else if(!checkUserService.checkPassword(user.getPassword())) {
			System.out.println("Parola en az 6 karakter olmalýdýr.");
		}else if(!checkUserService.checkNewEmail(user.getEmail(), getAll())) {
			System.out.println("Bu e-posta zaten kayýtlý");
		}else if(!checkUserService.isValidEmail(user.getEmail())) {
			System.out.println("Hatalý e-posta");
		}else {
			userDao.register(user);
			System.out.println(user.getEmail() + " adresine doðrulama linki gönderildi.");
		}
	}

	@Override
	public void login(User user) {
		if(!checkUserService.isValidUser(user)) {
			System.out.println("Hatalý kullanýcý");
		}else if(!checkUserService.isVerifiedUser(user.getEmail())) {
			System.out.println("Henüz hesabýnýz onaylanmamýþ. Onay iþlemi ardýndan tekrar deneyiniz.");
		}
		else {
			userDao.login(user.getEmail(), user.getPassword());
			System.out.println("Giriþ baþarýlý");
		}
		
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

}
