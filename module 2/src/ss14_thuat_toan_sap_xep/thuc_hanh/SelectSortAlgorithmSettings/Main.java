package ss14_thuat_toan_sap_xep.thuc_hanh.SelectSortAlgorithmSettings;

import static ss14_thuat_toan_sap_xep.thuc_hanh.SelectSortAlgorithmSettings.SelectionSort.list;
import static ss14_thuat_toan_sap_xep.thuc_hanh.SelectSortAlgorithmSettings.SelectionSort.selectionSort;

public class Main {
    public static void main(String[] args) {
        selectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}

