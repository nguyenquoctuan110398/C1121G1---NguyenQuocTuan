package ss14_thuat_toan_sap_xep.thuc_hanh.BubbleSortAlgorithmSettings;

import static ss14_thuat_toan_sap_xep.thuc_hanh.BubbleSortAlgorithmSettings.BubbleSort.bubbleSort;
import static ss14_thuat_toan_sap_xep.thuc_hanh.BubbleSortAlgorithmSettings.BubbleSort.list;

public class Main {
    public static void main(String[] args) {
        bubbleSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
