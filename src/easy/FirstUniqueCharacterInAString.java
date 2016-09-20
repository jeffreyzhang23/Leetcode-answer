package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jeffrey on 2016/9/19.
 */
public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        //由于全是小写字母，所以开辟一个存放26个字母个数的整形数组，遍历s，将每个字母出现的次数存在数组中，
        //再根据s中字符位置遍历该整形数组，第一个字母个数为1的即为所求
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(array[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

}
