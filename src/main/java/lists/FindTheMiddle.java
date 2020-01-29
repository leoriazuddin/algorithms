package lists;

/**
 *Find the middle element of a singly linked list. Constraint: Do it in one pass over the list. If it is even number
 * of elements, then output the 2nd of the middle two elements. e.g.
 * 1. (standard positive case) For input: 1->2->3->nil, Output should be: 2
 * 2. (positive case with longer list, odd # of nodes). For input: 1->11->45->12->67->89->91->nil, Output should be 12
 * 3. (positive case with longer list, even # of nodes). For input: 1->11->45->12->67->89->nil, Output should be 12
 * (2nd of the middle two)
 * 4. For input: nil, output should be nil
 */
public class FindTheMiddle {

    public int middle(ListNode<Integer> n) {
        ListNode<Integer> p1 = n;
        ListNode<Integer> p2 = n;

        while(p2 !=null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1.value;
    }

    public static void main(String[] args) {
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode<Integer> even = ListHelper.createList(new int[]{2, 4, 3, 1, 7, 0, 9, 8, 6, 5});
        ListNode<Integer> odd = ListHelper.createList(new int[]{2, 4, 3, 1, 7, 0, 9, 8, 6, });

        FindTheMiddle m = new FindTheMiddle();
        System.out.println(m.middle(even));
        System.out.println(m.middle(odd));
    }

}
