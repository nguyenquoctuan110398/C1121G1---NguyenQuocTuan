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
        productArrayList = (ArrayList<Product>) readAndWriteFile.readObjectListProductToFile(pathFile);
//        productList = readAndWriteFile.readObjectListProductToFile(pathFile);
//        productList.add(product);
        productArrayList.add(product);
//        readAndWriteFile.writeObjectListProductToFile(productList, pathFile);
        readAndWriteFile.writeObjectListProductToFile(productArrayList, pathFile);
    }

    public void edit() {
        System.out.println("Enter id obj to edit: ");
        int idToEdit = Integer.parseInt(scanner.nextLine());
        productArrayList = (ArrayList<Product>) readAndWriteFile.readObjectListProductToFile(pathFile);
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

        readAndWriteFile.writeObjectListProductToFile(productArrayList, pathFile);
    }

    public void delete() {
        productArrayList = (ArrayList<Product>) readAndWriteFile.readObjectListProductToFile(pathFile);

        System.out.println("Enter id to delete: ");
        int idDelete = Integer.parseInt(scanner.nextLine());

        Product product = new Product(idDelete);
        productArrayList.remove(product);

//        boolean check = false;
//        if (productArrayList.isEmpty()) {
//            System.out.println("Product ArrayList is empty with nothing to delete");
//        } else {
//            System.out.println("Enter id to delete: ");
//            int idDelete = Integer.parseInt(scanner.nextLine());
//
//            for (int i = 0; i < productArrayList.size(); i++) {
//                if (idDelete == productArrayList.get(i).getId()) {
//                    productArrayList.remove(i);
//                    check = true;
//                    break;
//                }
//            }
//            if (check) {
//                System.out.println("Product deleted");
//            } else {
//                System.out.println("Cannot find the id to delete");
//            }
//        }
        readAndWriteFile.writeObjectListProductToFile(productArrayList, pathFile);
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
