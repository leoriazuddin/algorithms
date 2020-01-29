package lists;

import java.util.Stack;

/**
 * Zip a linked list from it two ends. e.g. Input: 1->2->3->4->5->6 Output: 1->6->2->5->3->4
 *
 * find middle.
 * if size is even: begin zipping from middle, if size is odd: skip the middle and begin zipping the
 * neighbors of middle.
 */
public class Zip {

    public void zip(ListNode<Integer> head) {

        ListNode<Integer> p1 = head, p2 = head, prev = null;
        Stack<ListNode<Integer>> s = new Stack<>();

        while (p2 != null && p2.next != null) {
            s.push(p1);
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode<Integer> right = p1;

        if (s.size() % 2 == 0) {
            right = p1.next;
        }

        while (!s.empty()) {
            ListNode<Integer> left = s.pop();

            left.next = right;
            right = right.next;
            left.next.next = prev;
            prev = left;
        }

        while(head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode<Integer> even =ListHelper.createList(new int[]{2, 4, 3, 1, 7, 0, 9, 8, 6});
        ListNode<Integer> odd =ListHelper.createList(new int[]{2, 4, 3, 1, 7, 0, 9, 8, 6, 5});

        Zip m = new Zip();
        m.zip(even);
        m.zip(odd);
    }
}
