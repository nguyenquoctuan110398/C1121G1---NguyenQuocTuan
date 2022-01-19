package ss14_thuat_toan_sap_xep.thuc_hanh.SelectSortAlgorithmSettings;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            /* Find the minimum in the list[i..list.length-1] */
            double currentMin = list[i]; //=1
            int currentMinIndex = i;// ==0

            for (int j = i + 1; j < list.length; j++) {//j=5
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            /* Swap list[i] with list[currentMinIndex] if necessary */
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
