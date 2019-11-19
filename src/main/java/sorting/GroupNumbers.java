package sorting;

import arrays.ArrayHelper;

/**
 * https://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
 */
public class GroupNumbers {

    void groupNumbers(int[] a) {

        int l = 0, r = a.length - 1;
        while (l < r) {
            while (a[l] % 2 == 0 && l < r) {
                l++;
            }
            while (a[r] % 2 != 0 && l < r) {
                r--;
            }
            if (l < r) {

                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;
                r--;
            }
        }

        ArrayHelper.printArray(a);
    }

    public static void main(String[] args) {
        int[] a = {12, 34, 45, 9, 8, 90, 3};
        GroupNumbers main = new GroupNumbers();
        main.groupNumbers(a);
    }
}
