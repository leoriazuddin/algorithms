package sorting;

import arrays.ArrayHelper;

public class MergeSort {

    void mergeSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);

        merge(a, low, mid, high);
    }

    void merge(int[] a, int low, int mid, int high) {

        int s1 = mid - low + 1;
        int s2 = high - mid;

        int[] a1 = new int[s1];
        int[] a2 = new int[s2];

        for (int i = 0; i < s1; i++) {
            a1[i] = a[i + low];
        }

        for (int i = 0; i < s2; i++) {
            a2[i] = a[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;
        while (i < s1 && j < s2) {
            if (a1[i] <= a2[j]) {
                a[k] = a1[i];
                i++;
            } else {
                a[k] = a2[j];
                j++;
            }
            k++;
        }

        while (i < s1) {
            a[k] = a1[i];
            k++;
            i++;
        }

        while (j < s2) {
            a[k] = a2[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] input = {10, 80, 30, 90, 40, 50, 70};
        MergeSort sort = new MergeSort();
        sort.mergeSort(input, 0, input.length - 1);
        ArrayHelper.printArray(input);
    }
}
