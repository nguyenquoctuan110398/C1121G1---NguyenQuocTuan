package s11_stack_queue.bai_tap.CountWordsInString;

import sun.reflect.generics.tree.Tree;
import sun.text.normalizer.UCharacter;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountWordsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string to count: "); // abc
        String string = scanner.nextLine();
        string = string.toLowerCase();

        string=string.trim().replaceAll("\\s+", " ");

        System.out.println(string);

        String[] arr = string.split(" ");

        Map<String, Integer> stringTree = new TreeMap<>();


        for (int i = 0; i < arr.length; i++) {
            if (!stringTree.keySet().contains(arr[i])) {
                stringTree.put(arr[i], 1);
            } else {
                stringTree.put(arr[i], stringTree.get(arr[i]) + 1);
            }
        }
        System.out.println(stringTree);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập vào 1 câu hoặc 1 văn bản cần đếm số từ");
//        String str = scanner.nextLine();
//        str = str.toLowerCase();
//        String[] arrayString = str.split(" ");
//        Map<String, Integer> myMap = new TreeMap<>();
//        myMap.put(arrayString[0], 1);
//
//        for (int i = 1; i < arrayString.length; i++) {
//            int count = 1;
//
//            for (String word : myMap.keySet()) {
//                if (word.equals(arrayString[i])) {
//                    count = myMap.get(word) + 1;
//                }
//            }
//            myMap.put(arrayString[i], count);
//        }
//        System.out.println(myMap);
//    }
}
