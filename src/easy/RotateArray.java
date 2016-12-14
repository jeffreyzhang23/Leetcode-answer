package easy;

import java.util.Arrays;

/**Rotate an array of n elements to the right by k steps
 * For example, with n = 7 and k = 3,
 * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 *
 * Hint:
 * Could you do it in-place with O(1) extra space?
 *
 * Related problem:
 * Reverse Words in a String II
 *
 * Tags: Array
 * Created by Jeffrey on 2016/12/12.
 */
public class RotateArray {
    /**
     *  O(n) Time, O(1) Space
     * Build a full circle of rotation
     * Start from current index and repeat exactly "length of array" times
     * 1. Calculate new index which is current index move k steps forward
     * If move out of range, just start from beginning again
     * newIdx = (curIdx + k ) % len
     * 2. Circle can be the same, for example, n = 6, k = 2
     * Index will be 0, 2, 4, 0, 2, 4
     * So save the start index of the circle
     * If start from there again, move one step forward
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums == null)
            return ;
        if(nums.length == 1 || k == 0 || nums.length == k)
            return ;
        int len= nums.length;
        k %= len;
        int idx = 0;
        int temp = nums[idx]; // the number to write to new index
        int temp2; // save the number at new index
        for(int i = 0, j = 0; i < len; i++) { // j is the start index of current circle
            idx = (idx + k) % len;
            temp2 = nums[idx];
            nums[idx] = temp; // write to new index
            temp = temp2; // next write
            if(idx == j) { // circle ends
                idx = ++j; // move to next circle
                temp = nums[idx];
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        rotate(new int[]{1, 2}, 1);
    }
}
