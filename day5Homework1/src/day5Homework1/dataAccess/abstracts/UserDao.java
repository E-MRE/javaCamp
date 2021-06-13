package day5Homework1.dataAccess.abstracts;

import java.util.List;

import day5Homework1.entities.concretes.User;

public interface UserDao {
	void register(User user);
	void login(String email, String password);
	List<User> getAll();
}
