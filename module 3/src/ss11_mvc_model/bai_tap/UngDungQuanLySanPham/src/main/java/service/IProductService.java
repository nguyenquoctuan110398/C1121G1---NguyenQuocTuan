package service;

import model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Integer id, String name, Double price, String description, String manufacturer);

    void remove(Integer id);

    List<Product> searchByName(String name);
}
