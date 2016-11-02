package easy;

/**
 * Created by Jeffrey on 2016/11/2.
 * Tags: Dynamic Programming
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int preMax = nums[0];
        int max = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int temp = preMax;
            preMax = max;
            max = Math.max(temp + nums[i], preMax);
        }
        return max;
    }
}
