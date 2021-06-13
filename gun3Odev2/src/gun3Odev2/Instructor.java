package gun3Odev2;

public class Instructor extends User {
	private String courseName;

	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instructor(int id, String name, String username, String email, String password, String courseName) {
		super(id, name, username, email, password);
		this.courseName = courseName;
	}
	
	public Instructor(User user, String courseName) {
		super(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getPassword());
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
