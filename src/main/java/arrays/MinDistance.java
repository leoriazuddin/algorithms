package arrays;

/**
 * https://www.geeksforgeeks.org/minimum-distance-between-two-occurrences-of-maximum/
 *
 * find min distance between max elements
 */
public class MinDistance {

    public static void main(String[] args) {
        int arr[] = {6, 3, 1, 3, 6, 4, 6};

        MinDistance m = new MinDistance();
        m.distance(arr);
    }

    void distance(int[] a) {
        int max = a[0];
        int idx = 0;
        int d = Integer.MAX_VALUE;

        for(int i = 1; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
                idx = i;
                d = Integer.MAX_VALUE;
            } else if(a[i] == max) {
                d = (i - idx) < d ? i - idx : d;
                idx = i;
            }
        }

        System.out.println("Min distance: "+d);
    }
}
