package gun3Odev2;

public class InstructorManager extends UserManager {
	@Override
	public void add(User user) {
		System.out.println(user.getName() + " eðitmen eklendi");
	}
	@Override
	public void update(User user) {
		System.out.println(user.getName() + " eðitmen güncellendi");
	}
	@Override
	public void delete(User user) {
		System.out.println(user.getName() + " eðitmen silindi");
	}
	@Override
	public void addMultiple(User[] users) {
		for(User user:users) {
			add(user);
		}
	}
}
