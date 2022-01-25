package ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.service.impl;

import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.model.Product;
import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.util.ReadAndWriteFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService1 {
    private static ArrayList<Product> productArrayList = new ArrayList<>();
    //    private static Product product = new Product();
    Scanner scanner = new Scanner(System.in);
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    private static final String pathFile = "src/ss12_java_collection_framework/bai_tap/PracticeUsingArrayListLinkedList/util/fileProduct.csv";



    public void createProduct() {
        List<Product> productList = new ArrayList<>();
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name product: ");
        String name = scanner.nextLine();
        System.out.println("Enter price product: ");
        Double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
//        productArrayList = (ArrayList<Product>) readAndWriteFile.readObjectListProductToFile(pathFile);
//        productList = readAndWriteFile.readObjectListProductToFile(pathFile);
//        productList.add(product);
        productArrayList.add(product);
//        readAndWriteFile.writeObjectListProductToFile(productList, pathFile);
        readAndWriteFile.writeObjectListProductToFile(productArrayList, pathFile);
    }

    public void edit() {

    }

    public void delete() {

    }

    public void findAll() {
        List<Product> productList = readAndWriteFile.readObjectListProductToFile(pathFile);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void search() {

    }

    public void sort() {

    }
}
