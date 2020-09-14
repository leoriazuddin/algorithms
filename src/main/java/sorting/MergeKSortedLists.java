package sorting;

import lists.ListHelper;
import lists.ListNode;

/** Merge K sorted lists */
public class MergeKSortedLists {

  public ListNode<Integer> merge(ListNode[] lists) {
    ListNode head = lists[0];

    for (int i = 1; i < lists.length; i++) {
      head = recursion(head, lists[i]);
    }

    return head;
  }

  private ListNode<Integer> recursion(ListNode<Integer> m, ListNode<Integer> n) {
    if (m == null) return n;
    if (n == null) return m;

    if (m.value < n.value) {
      m.next = recursion(m.next, n);
      return m;
    }

    n.next = recursion(m, n.next);
    return n;
  }

  private ListNode<Integer> iterative(ListNode<Integer> m, ListNode<Integer> n) {
    ListNode<Integer> head = null, prev = null;

    while (m != null && n != null) {
      System.out.println("comparing " + m.value + ", " + n.value);
      if (m.value < n.value) {
        if (head == null) {
          head = m;
        }
        prev = m;
        m = m.next;
      } else {
        if (head == null) {
          head = n;
        }
        if (prev != null) {
          prev.next = n;
        }
        ListNode temp = n.next;
        n.next = m;
        m = n;
        n = temp;
      }
      //      ListHelper.printList(head);
      //      System.out.println();
    }

    if (m == null) {
      prev.next = n;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode<Integer> n1 = ListHelper.createList(new int[] {0, 1, 2, 13});
    ListNode<Integer> n2 = ListHelper.createList(new int[] {0, 2, 4, 11});
    ListNode<Integer> n3 = ListHelper.createList(new int[] {-1, 0, 7, 14, 15});

    MergeKSortedLists main = new MergeKSortedLists();
    ListNode<Integer> head = main.merge(new ListNode[] {n1, n3, n2});
    ListHelper.printList(head);
  }
}
