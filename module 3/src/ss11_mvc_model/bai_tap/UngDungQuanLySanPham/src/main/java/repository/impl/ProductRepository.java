package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Coca", 10000.0, "Chai", "Cocacola"));
        productList.add(new Product(2, "7up", 10000.0, "Lon", "ABC"));
        productList.add(new Product(3, "Aquafina", 5000.0, "Chai", "ABC"));
        productList.add(new Product(4, "Fanta", 10000.0, "Chai", "ABC"));
        productList.add(new Product(5, "Sting dâu", 10000.0, "Chai", "Sting"));
    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(Integer id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Integer id, String name, Double price, String description, String manufacturer) {
        for (Product product: productList){
            if (product.getId()==id){
                product.setName(name);
                product.setPrice(price);
                product.setDescription(description);
                product.setManufacturer(manufacturer);
                break;
            }
        }

    }

}
