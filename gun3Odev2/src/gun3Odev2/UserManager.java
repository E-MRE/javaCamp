package gun3Odev2;

public class UserManager {
	public void add(User user) {
		System.out.println(user.getName() + " kullanýcý eklendi");
	}
	
	public void update(User user) {
		System.out.println(user.getName() + " kullanýcý güncellendi");
	}
	
	public void delete(User user) {
		System.out.println(user.getName() + " kullanýcý silindi");
	}
	
	public void addMultiple(User[] users) {
		for(User user:users) {
			add(user);
		}
	}
}
