package ss14_thuat_toan_sap_xep.bai_tap.InsertionSortSettings;

import static ss14_thuat_toan_sap_xep.bai_tap.InsertionSortSettings.InsertionSort.list;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
        //insert list[i] into a sorted sublist list[0...i-1]
        //so that list[0..i] is sorted
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
        //insert the current elemtn into list[k+1]
            list[k + 1] = currentElement;
        }
    }
}
