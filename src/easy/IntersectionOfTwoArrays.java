package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jeffrey on 2016/9/18.
 */
public class IntersectionOfTwoArrays {
    static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(Integer i : nums1) {
            set1.add(i);
        }
        for(Integer i : nums2) {
            set2.add(i);
        }
        for(Integer i : set1) {
            if(set2.contains(i)) {
                list.add(i);
            }
        }
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            intersection2(nums2, nums1);
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int n : nums1) {
            set.add(n);
        }
        Set<Integer> intersect = new HashSet<>(nums1.length);
        for (int n : nums2) {
            if (set.contains(n)) {
                intersect.add(n);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {0};
        int[] nums4 = {1};
        System.out.print(Arrays.toString(intersection(nums1, nums2)));
        System.out.print(Arrays.toString(intersection(nums3, nums4)));
    }
}
