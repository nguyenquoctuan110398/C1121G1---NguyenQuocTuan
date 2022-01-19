package ss14_thuat_toan_sap_xep.bai_tap.InsertionSortIllustration;

import static ss14_thuat_toan_sap_xep.bai_tap.InsertionSortIllustration.InsertionSortByStep.insertionSort;
import static ss14_thuat_toan_sap_xep.bai_tap.InsertionSortIllustration.InsertionSortByStep.list;

public class Main {
    public static void main(String[] args) {
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertionSort(list);
    }
}
