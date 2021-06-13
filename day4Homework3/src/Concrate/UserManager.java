package Concrate;

import Abstract.UserCheckService;
import Abstract.UserService;
import Entity.User;

public class UserManager implements UserService {

	UserCheckService userCheckService;

	public UserManager(UserCheckService userCheckService) {
		this.userCheckService = userCheckService;
	}

	@Override
	public void register(User user) {
		if(userCheckService.checkUser(user)) {
			System.out.println(user.getName() + " kayýt oldu");
		}
		else {
			System.out.println("kullanýcý doðrulanamadý");
		}
	}

	@Override
	public void update(User user) {
		System.out.println(user.getName() + " bilgileri güncellendi");
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getName() + " sistemden silindi");
	}

}
