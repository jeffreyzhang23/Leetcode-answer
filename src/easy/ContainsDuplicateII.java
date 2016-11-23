package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 * <p>
 * Tags: Array, Hash Table
 * Similar Problems: (E) Contains Duplicate, (M) Contains Duplicate III
 * Created by Jeffrey on 2016/11/23.
 */
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) {
                set.remove(nums[i - k - 1]);
            }
            if(!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 8, 1};
        int[] array1 = new int[]{99, 99};
        int[] array2 = new int[]{1, 2};
        System.out.println(containsNearbyDuplicate(array, 3));
        System.out.println(containsNearbyDuplicate(array1, 1));
        System.out.println(containsNearbyDuplicate(array2, 2));
    }
}
