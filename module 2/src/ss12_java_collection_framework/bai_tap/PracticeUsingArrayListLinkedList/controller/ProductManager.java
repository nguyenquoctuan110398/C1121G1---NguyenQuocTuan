package ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.controller;

import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.service.IProductService;
import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.service.impl.ProductService;

import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IProductService iProductService = new ProductService();
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
                    iProductService.createProduct();
                    break;
                case 2:
                    iProductService.edit();
                    break;
                case 3:
                    iProductService.delete();
                    break;
                case 4:
                    iProductService.findAll();
                    break;
                case 5:
                    iProductService.search();
                    break;
                case 6:
                    iProductService.sort();
                    break;
                default:
                    break;
            }
        }
    }
}
