package lists;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
 *
 * Special list - next pointer points to next node but prev pointer points to any node in the list.
 *
 * Approach 1: clone a node1 and insert it between node1 and node2, repeat until end
 * Approach 2: use hashmap, key is original and value is clone
 */
public class CloneSpecialList {

    SpecialNode clone(SpecialNode head){

        Map<SpecialNode, SpecialNode> map = new HashMap<>();
        SpecialNode n = head, clone = null;
        while(n != null) {
            map.computeIfAbsent(n, k -> new SpecialNode(k.value));
            n = n.next;
        }

        //Traverse again to set arbit and next node.
        n = head;
        while(n != null) {
            clone.arbit = map.get(n.arbit);
            clone.next = map.get(n.next);

            n = n.next;
        }

        return map.get(head);
    }

    private static class SpecialNode {
        int value;
        SpecialNode arbit;
        SpecialNode next;

        SpecialNode(int value) {
            this.value = value;
        }
    }
}
