package easy;

/**104. Maximum Depth of Binary Tree
 * Created by Jeffrey on 2016/9/8.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int n) {
        val = n;
    }
}

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return theDepth(root);
    }

    private int theDepth(TreeNode root) {
        int leftDepth = 1;
        int rightDepth = 1;

        if (root.left != null) {
            leftDepth = theDepth(root.left) + 1;
        }
        if (root.right != null) {
            rightDepth = theDepth(root.right) + 1;
        }
        return Math.max(leftDepth, rightDepth);
    }
}
