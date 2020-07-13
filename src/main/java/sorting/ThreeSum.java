package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/description/ Find all unique triplets which give the sum of zero
 *
 * Approach (2 is used here - Complexity O(n^2)):
 *  1. Three nested for loops. Complexity O(n^3)
 *  2. Sort the array.
 *      for each element, check if there are 2 more elements where sum == 0
 *      if sum < 0, move in from left end, else move in from right end.
 *  3. Use Set (cannot find duplicates)
 *      for each element a[i], add it to set, check if there are 2 numbers that add up to -a[i]
 */
public class ThreeSum {

    // T - O(n^2) , S - O(1)
    public List<List<Integer>> threeSum(int[] a) {
        // O(n logn)
        Arrays.sort(a);
        System.out.println("Sorted : " + Arrays.toString(a));
        List<List<Integer>> lst = new ArrayList<>();
        int len = a.length;

        //O(n^2)
        for (int i = 0; i + 2 < len; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }

            int p = i + 1, q = len - 1;
            while (p < q) {
                int total = a[p] + a[q] + a[i];
                System.out.println(a[i] + " + " + a[p] + " + " + a[q] + " = " + total);
                if (total == 0) {
                    lst.add(Arrays.asList(a[i], a[p], a[q]));
                    p++;
                    q--;
                } else if (total < 0) {
                    p++;
                } else {
                    q--;
                }
            }

        }
        return lst;
    }

    public static void main(String[] args) {
        int[] s = {-1, 0, 1, 2, -1, -4};
        //        int [] s = {0,0,0,0};
        //        int [] s = {1,-1,-1,0};
        //        int [] s = {-2,0,1,1,2};
        //        int[] s = {-2, 0, 0, 2, 2};
        ThreeSum m = new ThreeSum();
        List<List<Integer>> lst = m.threeSum(s);
        System.out.println(Arrays.toString(lst.toArray()));
    }
}
