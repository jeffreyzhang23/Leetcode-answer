package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeffrey on 2016/9/26.
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0)
            return nums1;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i : nums1) {
            list1.add(i);
        }
        for(int i : nums2) {
            if(list1.contains(i)) {
                list1.remove((Integer) i);
                list2.add(i);
            }
        }
        int[] result = new int[list2.size()];
        for(int i = 0; i < list2.size(); i++) {
            result[i] = list2.get(i);
        }
        return result;
    }
}
