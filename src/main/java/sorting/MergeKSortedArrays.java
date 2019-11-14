package sorting;

import arrays.ArrayHelper;

public class MergeKSortedArrays {

    void merge(int[][] arrays) {
        int resultSize = 0;

        for (int[] array : arrays) {
            resultSize += array.length;
        }

        int[] result = new int[resultSize];
        int i = 0;
        for (int[] array : arrays) {
            for (int v : array) {
                result[i] = v;
                i++;
            }
        }

        MergeSort sort = new MergeSort();
        sort.mergeSort(result, 0, result.length - 1);
        ArrayHelper.printArray(result);
    }

    public static void main(String[] args) {
        int[][] input = {{2, 6, 12, 34}, {1, 9, 20, 1000}, {23, 34, 90, 2000}};
        MergeKSortedArrays sort = new MergeKSortedArrays();
        sort.merge(input);
    }

}
