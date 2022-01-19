package ss14_thuat_toan_sap_xep.bai_tap.InsertionSortSettings;

import static ss14_thuat_toan_sap_xep.bai_tap.InsertionSortSettings.InsertionSort.insertionSort;
import static ss14_thuat_toan_sap_xep.bai_tap.InsertionSortSettings.InsertionSort.list;

public class Main {
    public static void main(String[] args) {
        insertionSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
