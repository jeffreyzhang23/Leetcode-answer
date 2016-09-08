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
    static int maxDepth(TreeNode root) {
        int counterLeft = 1, counterRight = 1;
        TreeNode currentNode = null;
        if(root.left == null || root.right == null) return 1;
        currentNode = root;
        while(currentNode.left != null) {
            currentNode = currentNode.left;
            counterLeft++;
        }
        while(currentNode.right != null) {
            currentNode = currentNode.right;
            counterRight++;
        }

        return counterLeft > counterRight ? counterLeft : counterRight;
    }
}
