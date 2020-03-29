package trees;

import trees.TreeHelper.TreeNode;

/**
 * https://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals/
 *
 * Given inorder and level order, construct the tree
 */
public class TreeFromInAndLevelOrder {

    public static void main(String[] args) {

        int[] in = {4, 8, 10, 12, 14, 20, 22};
        int[] level = {20, 8, 22, 4, 12, 10, 14};

        TreeFromInAndLevelOrder m = new TreeFromInAndLevelOrder();
        TreeNode root = m.buildTree(in, level, 0, in.length - 1, null);
        TreeHelper.inorder(root);
    }

    TreeNode buildTree(int[] in, int[] level, int inStart, int inEnd, TreeNode n) {

        if(inStart > inEnd)
            return null;

        if(inStart == inEnd)
            return new TreeNode(in[inStart]);

        int idx = 0;
        boolean found = false;
        for(int i = 0; i < level.length; i++) {
            int data = level[i];
            for(int j = inStart; j < inEnd; j++) {
                if (data == in[j]){
                    n = new TreeNode(data);
                    found = true;
                    idx = j;

                    break;
                }
            }

            if(found)
                break;
        }

        n.left = buildTree(in, level, inStart, idx -1, n);
        n.right = buildTree(in, level, idx + 1, inEnd, n);

        return n;
    }
}
