package lists;

public class ListNode<T> {

    public ListNode<T> next;
    public T value;

    public ListNode(T value) {
        this.value = value;
    }
}
