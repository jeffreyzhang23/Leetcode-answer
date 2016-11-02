package easy;

import java.util.Stack;

/**
 * Created by Jeffrey on 2016/11/2.
 */
public class SymmetricTree {
    /**
     * Use a stack to store nodes in order
     * Then pop and compare
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null || node1.val != node2.val) return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }

    /**
     * Recursive, pre-order traversal
     * Check two symmetric nodes a time
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode node1, TreeNode node2) {
        if(node1 == null || node2 == null) return node1 == node2;
        return node1.val == node2.val && helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }
}
