package arrays;

/**
 * Sort an array of 0, 1 and 2 https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 *
 */
public class DutchNationalFlag {

    void sort(int[] a) {
        int start = 0, mid = 0, end = a.length - 1;

        while (mid <= end) {
            //Very important: this is if condition, not else if.
            if (a[mid] == 0) {
                swap(a, mid, start);
                mid++;
                start++;
            }
            if (a[mid] == 1) {
                mid++;
            }
            if (a[mid] == 2) {
                swap(a, mid, end);
                end--;
            }
        }
    }

    void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
