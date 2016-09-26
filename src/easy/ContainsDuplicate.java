package easy;

import java.util.*;

/**
 * Created by Jeffrey on 2016/9/26.
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length < 2)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        if(set.size() != nums.length)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {0};
        System.out.println(containsDuplicate(a));
        System.out.println(containsDuplicate(b));
    }
}
