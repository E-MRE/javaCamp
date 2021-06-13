package day5Homework1.business.abstracts;

import java.util.List;

import day5Homework1.entities.concretes.User;

public interface CheckUserService {
	boolean checkNewEmail(String email, List<User> userList);
	boolean checkPassword(String password);
	boolean isValidUser(User user);
	boolean isValidEmail(String email);
	boolean isVerifiedUser(String email);
}
