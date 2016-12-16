package easy;

import java.util.HashMap;

/**
 * Created by Jeffrey on 2016/12/15.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees
 * (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented
 as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 *
 */
public class StrobogrammaticNumber {
    /**
     * 翻转后对称的数就那么几个，我们可以根据这个建立一个映射关系：8->8, 0->0, 1->1, 6->9, 9->6，
     * 然后从两边向中间检查对应位置的两个字母是否有映射关系就行了。比如619，先判断6和9是有映射的，然
     * 后1和自己又是映射，所以是对称数。
     */
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('8', '8');
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        int left = 0;
        int right = num.length() - 1;
        while(left <= right) {
            if(!map.containsKey(num.charAt(right)) || num.charAt(left) != map.get(num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
