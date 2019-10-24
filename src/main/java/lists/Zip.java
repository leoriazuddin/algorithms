package lists;

import java.util.Stack;

/**
 * Zip a linked list from it two ends. e.g. Input: 1->2->3->4->5->6 Output: 1->6->2->5->3->4
 *
 * find middle.
 * if size is even: begin zipping from middle if size is odd: skip the middle and begin zipping the
 * neighbors of middle.
 */
public class Zip {

    public void zip(ListNode<Integer> head) {

        ListNode<Integer> p1 = head, p2 = head, prev = p1;
        Stack<ListNode<Integer>> s = new Stack<>();

        while (p2 != null && p2.next != null) {
            prev = p1;
            s.push(prev);
            p1 = p1.next;
            p2 = p2.next.next;
        }

        System.out.println(p1.value + " " + s.size());

        ListNode<Integer> right = p1;

        if (s.size() % 2 == 0) {
            right = p1.next;
        }

        while (!s.empty()) {
            ListNode<Integer> left = s.pop();
            int temp = left.value;
            left.value = right.value;
            right.value = temp;

            right = right.next;
        }

        while(head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        //2, 4, 3, 1, 7, 0, 9, 8, 6, 5

        ListNode<Integer> a = new ListNode<>(2);
        a.next = new ListNode<>(4);
        a.next.next = new ListNode<>(3);
        a.next.next.next = new ListNode<>(1);
        a.next.next.next.next = new ListNode<>(7);
        a.next.next.next.next.next = new ListNode<>(0);
        a.next.next.next.next.next.next = new ListNode<>(9);
        a.next.next.next.next.next.next.next = new ListNode<>(8);
        a.next.next.next.next.next.next.next.next = new ListNode<>(6);
//        a.next.next.next.next.next.next.next.next.next = new ListNode<>(5);

        Zip m = new Zip();
        m.zip(a);
    }
}
