package services;

import java.util.List;

import model.Product;

public interface ProductService {

	public List<Product> getProducts();

	public Product getProduct(long id);

	public Product newProduct(Product product);

	public Product updateProduct(Product product);

	public Product deleteProduct(long id);
}
