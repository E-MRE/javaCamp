package gun3Odev2;

public class StudentManager extends UserManager {
	@Override
	public void add(User user) {
		System.out.println(user.getName() + " ��renci eklendi");
	}
	@Override
	public void update(User user) {
		System.out.println(user.getName() + " ��renci g�ncellendi");
	}
	@Override
	public void delete(User user) {
		System.out.println(user.getName() + " ��renci silindi");
	}
	@Override
	public void addMultiple(User[] users) {
		for(User user:users) {
			add(user);
		}
	}
}
