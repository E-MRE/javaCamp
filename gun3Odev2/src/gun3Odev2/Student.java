package gun3Odev2;

public class Student extends User {
	private String lesson;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String username, String email, String password, String lesson) {
		super(id, name, username, email, password);
		this.lesson = lesson;
	}
	
	public Student(User user, String lesson) {
		super(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getPassword());
		this.lesson = lesson;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
	
	
}
