package CrudGestion.service;

import java.util.List;
import java.util.Optional;
import CrudGestion.model.Product;;

public interface IProductService {
	public List<Product>list();
	public Optional<Product>listById(int id);
	public int save(Product p);
	public void delete(int id);
}