package easy;

/**Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to
 * the nearest leaf node.
 *
 * Depth-first-search
 * Created by Jeffrey on 2016/11/21.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        else
            return getMinDepth(root.left, root.right, 1);
    }
    public int getMinDepth(TreeNode rootLeft, TreeNode rootRight, int n) {
        if(rootLeft == null && rootRight == null)
            return n;
        if(rootLeft == null)
            return getMinDepth(rootRight.left, rootRight.right, n + 1);
        else if(rootRight == null)
            return getMinDepth(rootLeft.left, rootLeft.right, n + 1);
        else
            return Math.min(getMinDepth(rootLeft.left, rootLeft.right, n + 1), getMinDepth(rootRight.left, rootRight.right, n + 1));
    }
}