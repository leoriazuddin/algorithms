package lists;

public class DoubleLinkedListNode {

    private int value;
    private DoubleLinkedListNode next;
    private DoubleLinkedListNode previous;

    public DoubleLinkedListNode(int value) {
        this.value = value;
    }

    public DoubleLinkedListNode(int value, DoubleLinkedListNode previous, DoubleLinkedListNode next) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public DoubleLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }

    public DoubleLinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedListNode previous) {
        this.previous = previous;
    }
}
