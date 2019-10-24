package lists;

public class FindTheMiddle {

    public int middle(ListNode<Integer> n) {
        ListNode<Integer> p1 = n;
        ListNode<Integer> p2 = n;

        while(p1 != null && p2 !=null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1.value;
    }

    public static void main(String[] args) {
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode<Integer> a = new ListNode<>(2);

        a.next = new ListNode<>(4);
        a.next.next = new ListNode<>(3);
        a.next.next.next = new ListNode<>(1);
        a.next.next.next.next = new ListNode<>(7);
        a.next.next.next.next.next = new ListNode<>(0);
        a.next.next.next.next.next.next = new ListNode<>(9);
        a.next.next.next.next.next.next.next = new ListNode<>(8);
        a.next.next.next.next.next.next.next.next = new ListNode<>(6);
        a.next.next.next.next.next.next.next.next.next = new ListNode<>(56);

        FindTheMiddle m = new FindTheMiddle();
        System.out.print(m.middle(a));
    }
}
