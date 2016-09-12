package easy;

/**
 * Created by Jeffrey on 2016/9/12.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        recursion(root);
        return root;
    }
    public TreeNode recursion(TreeNode root) {
        if(root.left == null && root.right == null)
            return root;
        else if(root.left == null && root.right != null){
            root.left = root.right;
            root.right = null;
            recursion(root.left);
        }else if(root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
            recursion(root.right);
        }else if(root.left != null && root.right != null) {
            TreeNode temp = new TreeNode(0);
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            recursion(root.left);
            recursion(root.right);
        }
        return null;
    }
    //第二种解法
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;

        TreeNode node = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree2(node);

        return root;
    }
}