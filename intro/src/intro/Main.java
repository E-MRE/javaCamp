package intro;

public class Main {

	public static void main(String[] args) {
		double dolarDun=8.45;
		double dolarBugun=8.30;
		if(dolarBugun>dolarDun) {
			System.out.println("Dolar arttý");
		}
		else if(dolarBugun<dolarDun){
			System.out.println("Dolar dustu");
		}
		else {
			System.out.println("Dolar eþit");
		}
		
		String[] krediler= {"A","B","C"};
		for(String kredi:krediler) {
			System.out.println(kredi);
		}
		
		int[] sayi1= {1,2,3,4};
		int[] sayi2= {10,20,30,40};
		sayi1=sayi2;
		sayi2[0]=100;
		System.out.println(sayi1[0]);

		String a="evin";
		System.out.println(a);

	}

}
