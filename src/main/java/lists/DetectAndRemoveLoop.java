package lists;
/**
 *  Ways to find loop:
 *  1. add nodes to set, if node already exists then there is loop
 *  2. (this algorithm)
 *      a. Go through the loop with two nodes, slow and fast, they will intersect if there is loop.
 *      b. the distance of loop node from intersection point (I) and the head (H) will be same.
 *      c. iterate from I and H until they are equal. this is the loop (L) point.
 *      d. To remove the loop, set the next of previous node of L to null.
 *
 */
public class DetectAndRemoveLoop {


    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(10);
        head.next = new ListNode<>(20);
        head.next.next = new ListNode<>(50);
        head.next.next.next = new ListNode<>(40);
        head.next.next.next.next = new ListNode<>(100);
        head.next.next.next.next.next = new ListNode<>(70);

        head.next.next.next.next.next.next = head.next.next;

        detectAndRemoveLoop(head);
    }

    private static boolean detectAndRemoveLoop(ListNode head) {
        ListNode<Integer> slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("Found loop, intersection at: "+slow.value);
                removeLoop(head, slow);
                ListHelper.printList(head);
                return true;
            }
        }

        return false;
    }

    private static void removeLoop(ListNode<Integer> head, ListNode<Integer> intersectionNode) {
        ListNode<Integer> p1 = head, p2 = intersectionNode, previous = null;
        while (p1 != p2) {
            p1 = p1.next;
            previous = p2;
            p2 = p2.next;
        }

        previous.next = null;
        System.out.println("Loop removed successfully.");
    }
}
