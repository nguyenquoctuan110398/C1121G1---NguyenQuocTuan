package ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.service.impl;

import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.model.Product;
import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.model.ProductsSortedByPriceAscending;
import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.model.ProductsSortedByPriceDescending;
import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.service.IProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService implements IProductService {
    Scanner scanner = new Scanner(System.in);
    private static ArrayList<Product> productArrayList = new ArrayList<>();
//    private static Product product = new Product();

    static {
        Product product = new Product(1, "Coca", 10000);
        productArrayList.add(product);
        Product product1 = new Product(2, "Nước suối", 5000);
        productArrayList.add(product1);
    }

    public void findAll() {
        for (Product a : productArrayList) {
            System.out.println(a);

        }
//        System.out.println(products);
    }

    @Override
    public void edit() {
        System.out.println("Enter id obj to edit: ");
        int idToEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productArrayList.size(); i++) {
            if (idToEdit == productArrayList.get(i).getId()) {
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                productArrayList.get(i).setName(name);
                System.out.println("Enter new price: ");
                double price = Double.parseDouble(scanner.nextLine());
                productArrayList.get(i).setPrice(price);
                break;
            }
        }
    }

    @Override
    public void delete() {
        if (productArrayList.isEmpty()) {
            System.out.println("Product ArrayList is empty with nothing to delete");
        } else {
            System.out.println("Enter id to delete: ");
            int idDelete = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < productArrayList.size(); i++) {
                if (idDelete == productArrayList.get(i).getId()) {
                    productArrayList.remove(i);
                    break;
                }

            }
            System.out.println("Cannot find the id to delete");
        }
    }

    @Override
    public void search() {
        System.out.println("Enter name to search: ");
        String nameToSearch= scanner.nextLine().toLowerCase();

        for (Product product:productArrayList){
            if ((product.getName().toLowerCase()).contains(nameToSearch)){
                System.out.println(product);
            } else {
                System.out.println("Can not find!!!");
            }
        }
    }

    @Override
    public void sort() {
        System.out.println("Sort ascending: ");
        productArrayList.sort(new ProductsSortedByPriceAscending());
        findAll();
        System.out.println("Sort descending: ");
        productArrayList.sort(new ProductsSortedByPriceDescending());
        findAll();
    }

    @Override
    public void createProduct() {
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name product: ");
        String name = scanner.nextLine();
        System.out.println("Enter price product: ");
        Double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
        productArrayList.add(product);
    }
}
