package sorting;

import arrays.ArrayHelper;

/**
 * - pick a pivot (last element)
 * - move all small element to left and greater elements to right
 * - do this recursively
 *
 */
public class QuickSort {

    void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIdx = partition(a, low, high);
        quickSort(a, low, pivotIdx - 1);
        quickSort(a, pivotIdx + 1, high);

        System.out.print(String.format("QuickSort[%s,%s]\t", low, high));
        ArrayHelper.printArray(a, low, high);
    }

    int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);

        System.out.print(String.format("Partition[%s,%s]\t", low, high));
        ArrayHelper.printArray(a, low, high);
        return i + 1;
    }

    void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int[] input = {10, 80, 30, 90, 40, 50, 70};
        QuickSort main = new QuickSort();
        main.quickSort(input, 0, input.length - 1);
        ArrayHelper.printArray(input);
    }
}
