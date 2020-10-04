package trees;

public class MaximumPathSum {

    /**
     * solution is not complete, Needs correction
     */
    public static void main(String[] args) {
        // find max between, maxPathSum(left), maxPathSum(right), maxPathSum(left) + node.val,
        // maxPathSum(right) + node.val
        // if root, maxPathSum(left) + maxPathSum(right) + n.val
        TreeHelper.TreeNode root = new TreeHelper.TreeNode(10);
        root.left = new TreeHelper.TreeNode(2);
        root.right = new TreeHelper.TreeNode(10);
        root.left.left = new TreeHelper.TreeNode(20);
        root.left.right = new TreeHelper.TreeNode(1);
        root.right.right = new TreeHelper.TreeNode(-25);
        root.right.right.left = new TreeHelper.TreeNode(3);
        root.right.right.right = new TreeHelper.TreeNode(4);

        System.out.println(maxPathSum(root, true));
    }

    static int maxPathSum(TreeHelper.TreeNode n, boolean isRoot) {
        if(n == null)
            return 0;

        int l = maxPathSum(n.left, false), r = maxPathSum(n.right, false);

        int lrMax = Math.max(Math.max(l, r), Math.max(l + n.value, r + n.value));

        System.out.println(n.value+": "+l +" "+r+" "+lrMax+" "+isRoot);

        return isRoot? Math.max(l + r + n.value, lrMax) : lrMax;
    }

}
