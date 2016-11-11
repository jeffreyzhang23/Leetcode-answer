package easy;

/**Given a <strong>sorted</strong> array, remove the duplicates in place such
 * that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place
 * with constant memory.
 *
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 *
 * Tags: Array, Two pointers
 * Created by Jeffrey on 2016/11/11.
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0 || nums[count - 1] != nums[i])
                nums[count++] = nums[i];
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        System.out.println(removeDuplicates(nums));
    }
}
