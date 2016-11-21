package easy;

/**Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Tags: Tree, DFS
 * Created by Jeffrey on 2016/11/16.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        sum -= root.val;
        return root.left == null && root.right == null && sum == 0 || hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
