package lists;

public class ListNode<T> {

    ListNode<T> next;
    T value;

    public ListNode(T value) {
        this.value = value;
    }
}
