package easy;

/**
 * Created by Jeffrey on 2016/12/15.
 * Given a non-empty binary search tree and a target value, find the value
 * in the BST that is closest to the target.
 *
 * Note: Given target value is a floating point. You are guaranteed to have
 * only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
    /**
     * Solution 1: Recursion
     * Recursively traverse down the root. When target is less than root, go left;
     * When target is greater than root, go right.
     */
    int goal;
    double min = Double.MAX_VALUE;
    public int closetValue(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }
    public void helper(TreeNode root, double target) {
        if(root == null) {
            return;
        }
        if(Math.abs(root.val - target) < min) {
            min = Math.abs(root.val - target);
            goal = root.val;
        }
        if(target < root.val) {
            helper(root.left, target);
        } else {
            helper(root.right, target);
        }
    }
    /**
     * 方法2：迭代
     */
    public int closetValue1(TreeNode root, double target) {
        if(root == null)
            return 0;
        int min = root.val;
        while(root != null) {
            min = Math.abs(target - root.val) < Math.abs(target - min) ? root.val : min;
            root = root.val < target ? root.right : root.left;
        }
        return min;
    }
}
