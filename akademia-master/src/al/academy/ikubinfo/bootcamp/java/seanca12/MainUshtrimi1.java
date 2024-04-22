package al.academy.ikubinfo.bootcamp.java.seanca12;

public class MainUshtrimi1 {

	public static void main(String[] args) {

		Person person = new Person();
		Student student = new Student(8, 8.5, "aaaa", "tirane");
		Pedagog pedagog = new Pedagog(3, 1000, "bbbb", "tirane");
		Student student1 = new Student();
		Pedagog pedagog1 = new Pedagog();

		person.setEmer("test");
		person.setAdrese("tirane");
		person.toString();

		student1.setEmer("student1");
		student1.setAdrese("tirane");
		student1.setMesatarja(8.75);
		student1.setNrLendesh(8);
		student1.toString();

		pedagog1.setEmer("pedagog1");
		pedagog1.setAdrese("tirane");
		pedagog1.setPaga(2000);
		pedagog1.setNrLendesh(4);
		pedagog1.toString();

	}

}
