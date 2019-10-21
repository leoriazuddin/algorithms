package lists;

public class ListHelper {

    public static void printList(ListNode<Integer> head){
        while(head != null) {
            System.out.print(String.format("%s ", head.value));
            head = head.next;
        }
    }
}
