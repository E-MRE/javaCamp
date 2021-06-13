package day5Homework1;

import day5Homework1.business.abstracts.UserService;
import day5Homework1.business.concretes.CheckUserManager;
import day5Homework1.business.concretes.UserManager;
import day5Homework1.core.concretes.GoogleManagerAdapter;
import day5Homework1.dataAccess.concretes.SavedUserDao;
import day5Homework1.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1, "Emre", "Denee", "emre12i@gmail.com", "1111111");
		User user2 = new User(2, "Bengü", "Sanane", "deneme@gmail.com", "22212311");

		UserService service = new UserManager(new SavedUserDao(), new CheckUserManager());
		service.register(user1);
		
		GoogleManagerAdapter googleAdapter = new GoogleManagerAdapter(new CheckUserManager());
		googleAdapter.loginToSystem(user2.getEmail(),user2.getPassword());

	}

}
