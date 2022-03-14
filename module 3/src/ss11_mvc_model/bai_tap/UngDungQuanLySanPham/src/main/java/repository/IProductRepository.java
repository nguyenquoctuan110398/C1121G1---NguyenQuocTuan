package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Integer id, String name, Double price, String description, String manufacturer);

    void remove(Integer id);
}
