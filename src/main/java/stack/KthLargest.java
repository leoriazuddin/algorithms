package stack;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * approach 1: sort the array
 * approach 2: this one
 * approach 3: use quicksort
 */
public class KthLargest {
    
    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k) {
        this.k = k;
        q = new PriorityQueue<>((a, b) -> { return b - a; });
    }

    public int kthLargest(int[] input) {
        for (int i : input) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    public static void main(String[] args) {
        KthLargest m = new KthLargest(2);
        System.out.println(m.kthLargest(new int[]{3, 2, 1, 5, 6, 4}));
    }
}

