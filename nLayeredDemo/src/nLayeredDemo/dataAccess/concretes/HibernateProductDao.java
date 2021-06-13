package nLayeredDemo.dataAccess.concretes;

import java.util.List;

import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

public class HibernateProductDao implements ProductDao {

	@Override
	public void add(Product product) {
		System.out.println("Hibernate ile eklendi " + product.getName());
		
	}

	@Override
	public void update(Product product) {
		System.out.println("Hibernate ile güncellendi " + product.getName());
		
	}

	@Override
	public void delete(Product product) {
		System.out.println("Hibernate ile silindi " + product.getName());
		
	}

	@Override
	public Product get(int id) {
		System.out.println("Hibernate ile ürün geldi");
		return null;
	}

	@Override
	public List<Product> getAll() {
		System.out.println("Hibernate ile listelendi");
		return null;
	}

}
