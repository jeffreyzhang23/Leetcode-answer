package easy;

import java.util.Arrays;

/**Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target.
 * You may assume that each input would have exactly one solution.
 * Created by Jeffrey on 2016/11/29.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2)
            return null;
        int[] res = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
