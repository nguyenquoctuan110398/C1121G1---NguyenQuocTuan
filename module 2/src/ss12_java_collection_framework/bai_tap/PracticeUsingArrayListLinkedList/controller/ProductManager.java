package ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.controller;

import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.service.IProductService;
import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.service.impl.ProductService;
import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.service.impl.ProductService1;

import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService1 productService1 = new ProductService1();
//        ArrayList<Product> productArrayList= new ArrayList<>();
        while (true) {
            System.out.println("1. Add product\n" +
                    "2. Edit product information\n" +
                    "3. Delete product\n" +
                    "4. Show product list\n" +
                    "5. Search product\n" +
                    "6. Sort product");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    productService1.createProduct();
                    break;
                case 2:
                    productService1.edit();
                    break;
                case 3:
                    productService1.delete();
                    break;
                case 4:
                    productService1.findAll();
                    break;
                case 5:
                    productService1.search();
                    break;
                case 6:
                    productService1.sort();
                    break;
                default:
                    break;
            }
        }
    }
}
