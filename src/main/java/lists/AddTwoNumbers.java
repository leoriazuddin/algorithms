package lists;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {

    public ListNode<Integer> add(ListNode<Integer> a, ListNode<Integer> b) {
        int carry = 0;
        ListNode<Integer> n = null;
        ListNode<Integer> result = null;
        while (a != null && b != null) {
            int sum = a.value + b.value + carry;
            carry = sum / 10;

            ListNode<Integer> newNode = new ListNode<>(sum % 10);
            if (n == null) {
                n = newNode;
                result = n;
            } else {
                n.next = newNode;
                n = n.next;
            }

            a = a.next;
            b = b.next;
        }

        while (a != null) {
            int sum = a.value + carry;
            carry = sum / 10;

            n.next = new ListNode<>(sum % 10);

            n = n.next;
            a = a.next;
        }

        while (b != null) {
            int sum = b.value + carry;
            carry = sum / 10;

            n.next = new ListNode<>(sum % 10);

            n=n.next;
            b=b.next;
        }

        if (carry != 0) {
            n.next = new ListNode<>(carry);
        }

        return result;
    }

    public static void main(String[] args) {
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode<Integer> a = new ListNode<>(2);
        a.next = new ListNode<>(4);
        a.next.next = new ListNode<>(3);
        a.next.next.next = new ListNode<>(3);

        ListNode<Integer> b = new ListNode<>(5);
        b.next = new ListNode<>(6);
        b.next.next = new ListNode<>(4);

        AddTwoNumbers m = new AddTwoNumbers();
        ListNode<Integer> result = m.add(a, b);
        while(result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
