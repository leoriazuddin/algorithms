package arrays;

import java.util.Stack;

/**
 * given and array,
 *  print indexes of elements which have all elements less than on right side.
 */
public class AllMininimumOnRight {


    public static void main(String[] args) {
        AllMininimumOnRight m = new AllMininimumOnRight();
        int[] a = {10, 12, 3, 7, 6, 8, 10};
        m.print(a);
    }

    /**
     * begin from right index and track the max value.
     * if current > max, it means all numbers on right are less than current,
     *  add idx or current to result, and update max
     *
     */
    void print(int[] a) {
        int max = a[a.length - 1];

        Stack<Integer> s = new Stack<>();
        s.push(a.length - 1);
        for(int i = a.length -2; i >= 0; i--) {
            if(a[i] > max) {
                s.push(i);
                max = a[i];
            }
        }

        System.out.println(s);
    }
}
