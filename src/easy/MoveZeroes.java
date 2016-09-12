package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeffrey on 2016/9/12.
 */
public class MoveZeroes {
    public static void moveZeros(int[] nums) {
        if(nums == null || nums.length == 0) return;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        for(int a : nums) {
            if(a == 0)
                list.add(a);
            else
                list1.add(a);
        }
        list1.addAll(list);
        System.out.print(list1);
        for(int i = 0; i < list1.size(); i++) {
            nums[i] = list1.get(i);
        }
    }
    //方法2
    public static void moveZeros2(int[] nums) {
        if(nums == null || nums.length == 0) return ;
        int count = 0;
        for(int n : nums) {
            if(n != 0) {
                nums[count++] = n;
            }
        }
        for(; count < nums.length; count++) {
            nums[count] = 0;
        }
    }
}
