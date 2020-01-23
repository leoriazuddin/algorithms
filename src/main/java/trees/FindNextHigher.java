package trees;

/**
 * Microsoft: 01/22/2020
 *
 * Given a node of BST, where every node has link to its parent, find the next higher node
 *
 * if n has right, return min(n.right)
 * if n has parent, return (root.value > n.value) ? root : n
 *
 * Expected:
 *  5 -> 7
 *  3 -> 5
 *  7 -> 8
 *  1 -> 2
 *  8 -> 10
 */
public class FindNextHigher {

    public static void main(String[] args) {
        NodeWithParent root = new NodeWithParent(5);
        root.left = new NodeWithParent(2);
        root.right = new NodeWithParent(8);
        root.left.parent = root;
        root.right.parent = root;

        root.left.left = new NodeWithParent(1);
        root.left.right = new NodeWithParent(3);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.left = new NodeWithParent(7);
        root.right.right = new NodeWithParent(10);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        FindNextHigher main = new FindNextHigher();
        System.out.println(main.findNextHigher(root.left.left));
    }

    int findNextHigher(NodeWithParent n) {
        if(n.right != null)
            return min(n.right).data;

        NodeWithParent input = n;
        while(n.parent != null) {
            if(n.parent.data > input.data)
                return n.parent.data;

            n = n.parent;
        }

        return input.data;
    }

    NodeWithParent min(NodeWithParent n) {
        if(n.left == null)
            return n;

        return min(n.left);
    }

    private static class NodeWithParent {
        NodeWithParent parent;
        NodeWithParent left;
        NodeWithParent right;
        int data;

        public NodeWithParent(int data) {
            this.data = data;
        }
    }
}
