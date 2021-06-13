package inheritance2;

public class Main {

	public static void main(String[] args) {
		CustomerManger customerManger = new CustomerManger();
		customerManger.add(new EmailLogger());

	}

}
