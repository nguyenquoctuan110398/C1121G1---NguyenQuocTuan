package ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.util;

import ss12_java_collection_framework.bai_tap.PracticeUsingArrayListLinkedList.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static void writeObjectListProductToFile(List<Product> productList, String pathFile) {
        File file = new File(pathFile);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Product> readObjectListProductToFile(String pathFile) {
        List<Product> productList = new ArrayList<>();
        File file = new File(pathFile);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            if (file.length() > 0) {
                objectInputStream = new ObjectInputStream(fileInputStream);
                productList = (ArrayList<Product>) objectInputStream.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
}
