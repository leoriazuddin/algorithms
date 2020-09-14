package sorting;

import arrays.ArrayHelper;

/**
 * https://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
 */
public class GroupNumbers {

    void groupNumbers(int[] a) {

        int left = 0, right = a.length - 1;
        while (left < right) {
            while (a[left] % 2 == 0 && left < right) {
                left++;
            }
            while (a[right] % 2 != 0 && left < right) {
                right--;
            }
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
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
