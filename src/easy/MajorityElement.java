package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeffrey on 2016/9/26.
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            Integer freq = map.get(i); // Integer can't be replaced by int, or the NullPointerException will occur.
            map.put(i, map.get(i) == null ? 1 : freq + 1);
        }
        System.out.println(map);
        for(int i : map.keySet()) {
            if(map.get(i) > nums.length / 2) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 1};
        System.out.println(majorityElement(a));
    }
}
