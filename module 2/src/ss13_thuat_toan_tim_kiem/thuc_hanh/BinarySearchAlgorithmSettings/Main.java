package ss13_thuat_toan_tim_kiem.thuc_hanh.BinarySearchAlgorithmSettings;

import static ss13_thuat_toan_tim_kiem.thuc_hanh.BinarySearchAlgorithmSettings.BinarySearch.binarySearch;
//import static ss13_thuat_toan_tim_kiem.thuc_hanh.BinarySearchAlgorithmSettings.BinarySearch.list;

public class Main {
    public static void main(String[] args) {
        System.out.println(binarySearch(BinarySearch.list, 2));  /* 0 */
        System.out.println(binarySearch(BinarySearch.list, 11)); /* 4 */
        System.out.println(binarySearch(BinarySearch.list, 79)); /*12 */
        System.out.println(binarySearch(BinarySearch.list, 1));  /*-1 */
        System.out.println(binarySearch(BinarySearch.list, 5));  /*-1 */
        System.out.println(binarySearch(BinarySearch.list, 80)); /*-1 */
    }
}
