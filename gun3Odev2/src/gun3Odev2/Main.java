package gun3Odev2;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(0,"Emre","Reiss","emre.123@gmail.com","123123");
		
		Student student1 =new Student(user1, "Java Dersi");
		
		Student student2 =new Student();
		student2.setId(1);
		student2.setName("Betül");
		student2.setUsername("betty");
		student2.setEmail("betty1@gmail.com");
		student2.setPassword("123456");
		student2.setLesson("Python Dersi");
		
		Instructor instructor =new Instructor();
		instructor.setId(2);
		instructor.setName("Engin");
		instructor.setUsername("engin11");
		instructor.setEmail("engin12@gmail.com");
		instructor.setPassword("987654");
		instructor.setCourseName("Java Dersi");
		
		Student[] students= {student1, student2};
		
		StudentManager studentManager=new StudentManager();
		InstructorManager instructorManager=new InstructorManager();
		
		studentManager.addMultiple(students);
		instructorManager.add(instructor);		

	}

}
