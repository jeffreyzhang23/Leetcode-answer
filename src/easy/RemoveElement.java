package easy;

import java.util.Arrays;

/**Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Created by Jeffrey on 2016/11/3.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 2, 3};
//        System.out.println(Arrays.toString(removeElement(array, 3)));
        System.out.println(removeElement(array, 3));
    }
}
