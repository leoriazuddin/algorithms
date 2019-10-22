package lists;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    private int capacity;
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode last;
    private Map<Integer, DoubleLinkedListNode> map = new HashMap<>();

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public void put(Integer key, Integer value) {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(value);
        if (head == null) {
            add(key, newNode);
            last = head;
        } else if (map.containsKey(key)) {
            add(key, newNode);
        } else {
            if (map.size() < capacity) {
                add(key, newNode);
            } else {
                map.remove(last.getValue());
                last = last.getPrevious();
                last.setNext(null);
                add(key, newNode);
            }
        }

        System.out.println(map);
    }

    public int get(Integer key) {
        if (!map.containsKey(key)) {

            System.out.println(-1);
            return -1;
        }

        DoubleLinkedListNode found = map.get(key);
        makeRecent(found);

        System.out.println(found.getValue());
        return found.getValue();
    }

    private void add(Integer key, DoubleLinkedListNode newNode) {
        map.put(key, newNode);
        makeRecent(newNode);
    }

    private void makeRecent(DoubleLinkedListNode newNode) {

        if(newNode == last) {
            last = last.getPrevious();
            last.setNext(null);
        }

        if (head != null) {
            newNode.setNext(head);
            head.setPrevious(newNode);
            newNode.setPrevious(null);
        }

        head = newNode;
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

}
