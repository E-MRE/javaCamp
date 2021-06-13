package oopIntro;

public class Main {

	public static void main(String[] args) {
		
		Product product1 = new Product(1,"Lenova",10000,"16 GB Ram", 10);
		
		Product product2 = new Product();
		product2.setId(2);
		product2.setName("Fare");
		product2.setDetail("Oyuncu Faresi");
		product2.setUnitPrice(50);
		product2.setDiscount(20);
		
		System.out.println(product2.getUnitPriceAfterDiscount());
		
		Category category1 = new Category();
		category1.setId(0);
		category1.setName("Yiyecek");
		
		Category category2 = new Category();
		category2.setId(1);
		category2.setName("Ýçecek");
		
		System.out.println(category2.getName());
		System.out.println(category2.getName());
	}

}
