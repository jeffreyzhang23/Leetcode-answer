package easy;

/**
 * Created by Jeffrey on 2016/10/26.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int res = pathWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return res;
    }
    public int pathWithRoot(TreeNode root, int  sum) {
        if(root == null) return 0;
        int res = 0;
        if(root.val == sum)
            res++;
        res += pathWithRoot(root.left, sum - root.val) + pathWithRoot(root.right, sum - root.val);
        return res;
    }
}
