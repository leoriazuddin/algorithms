package lists;

public class ListHelper {

    public static void printList(ListNode<Integer> head) {
        while (head != null) {
            System.out.print(String.format("%s ", head.value));
            head = head.next;
        }
    }

    public static ListNode<Integer> createSampleList() {
        return createList(new int[]{2, 4, 3, 1, 7, 0, 9, 8, 6, 5});
    }

    public static ListNode<Integer> createList(int[] array) {
        ListNode<Integer> head = new ListNode<>(array[0]);
        ListNode<Integer> a = head;

        for (int i = 1; i < array.length; i++) {
            a.next = new ListNode<>(array[i]);
            a = a.next;
        }

        return head;
    }
}
