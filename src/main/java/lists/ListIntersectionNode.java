package lists;

/**
 * 1. Set pointers to start of both nodes, and move towards the end.
 * 2. When a pointer reaches end of list, reset it to head of other list and keep iterating
 * 3. until both pointers are equal. This is the intersection.
 */
public class ListIntersectionNode {

    public static void main(String[] args) {
        ListNode<Integer> head1 = ListHelper.createList(new int[]{10, 20, 50, 40, 100, 70});
        ListNode<Integer> head2 = ListHelper.createList(new int[]{100, 120, 150, 140});

        head2.next.next.next.next = head1.next.next;
        findIntersetionNode(head1, head2);
    }

    private static ListNode<Integer> findIntersetionNode(ListNode<Integer> a, ListNode<Integer> b) {
        if(a == null || b == null) return null;

        ListNode<Integer> p1 = a, p2 = b;

        while(p1 != p2){
            p1 = p1 == null ? b : p1.next;
            p2 = p2 == null ? a : p2.next;
        }

        System.out.println(p1.value);
        return p1;
    }

}
