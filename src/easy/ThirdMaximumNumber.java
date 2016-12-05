package easy;

import java.util.TreeSet;

/**Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 *
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 *
 * Example 2:
 *
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned
 * instead.
 *
 * Example 3:
 *
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct
 * number.
 * Both numbers with value 2 are both considered as second maximum.
 * Created by jeffrey on 16-12-5.
 */
public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size() == 1) {
            return set.first();
        } else if(set.size() == 2) {
            return set.last();
        } else {
            for(int i = 0; i < 2; i++) {
                set.remove(set.last());
            }
            return set.last();
        }
    }
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 1}));
        System.out.println(thirdMax(new int[]{1, 2}));
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }
}
