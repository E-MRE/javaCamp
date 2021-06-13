package day5Homework1.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import day5Homework1.dataAccess.abstracts.UserDao;
import day5Homework1.entities.concretes.User;

public class SavedUserDao implements UserDao {

	@Override
	public void register(User user) {
		System.out.println(user.getName() + " kaydedildi");
		
	}

	@Override
	public void login(String email, String password) {
		System.out.println(email + " ile oturum açýldý");
		
	}

	@Override
	public List<User> getAll() {
		
		return new ArrayList<User>();
	}

}
