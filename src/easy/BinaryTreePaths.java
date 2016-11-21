package easy;

import java.util.ArrayList;
import java.util.List;

/**Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * |    1
 * |  /   \
 * | 2     3
 * |  \
 * |   5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 * <p>
 * Company Tags: Google, Apple, Facebook
 * Tags: Tree, Depth-first Search
 * Similar Problems: (M) Path Sum II
 *
 * Created by Jeffrey on 2016/11/14.
 */
public class BinaryTreePaths {
    /**
     * DFS.
     * The path from root to leaf can be obtained by:
     * At each node, add its left child's val to the path, traverse the left subtree.
     * Then add its right child's val to the path, traverse the right subtree.
     * The base case is when we reach a leaf, we add the path to result.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root != null)
            dfs(root, "", paths);
        return paths;
    }
    public void dfs(TreeNode root, String path, List<String> paths) {
        if(root.left == null && root.right == null) {
            paths.add(path + root.val);
        }
        if(root.left != null)
            dfs(root.left, path + root.val + "->", paths);
        if(root.right != null)
            dfs(root.right, path + root.val + "->", paths);
    }
    /**
     * DFS.
     * Recurrence relation:
     * The paths consists of root + all subtrees paths.
     * Base case:
     * If root is null, the list would be empty.
     * If the root is a leaf, then itself's value would be in list.
     * <p>
     * Just concatenate root's value with those paths returned from subtrees.
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null)
            return paths;
        if(root.left == null && root.right == null) {
            paths.add("" + root.val);
            return paths;
        }
        for(String path : binaryTreePaths1(root.left)) {
            paths.add(root.val + "->" + path);
        }
        for(String path : binaryTreePaths1(root.right)) {
            paths.add(root.val + "->" + path);
        }
        return  paths;
    }
}
