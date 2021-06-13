package gun3Odev2;

public class UserManager {
	public void add(User user) {
		System.out.println(user.getName() + " kullan�c� eklendi");
	}
	
	public void update(User user) {
		System.out.println(user.getName() + " kullan�c� g�ncellendi");
	}
	
	public void delete(User user) {
		System.out.println(user.getName() + " kullan�c� silindi");
	}
	
	public void addMultiple(User[] users) {
		for(User user:users) {
			add(user);
		}
	}
}
