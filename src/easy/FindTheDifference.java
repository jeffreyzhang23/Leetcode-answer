package easy;

import java.util.*;

/**
 * Created by Jeffrey on 2016/9/12.
 */
public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        char ans;
        List<Character> list = new ArrayList<Character>();
        List<Character> list1= new ArrayList<Character>();
        for(int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        for(char ch : chars1) {
            list1.add(ch);
        }
        for(Character ch : list) {
            if(list1.contains(ch)) {
                list1.remove(ch);
            }
        }
        ans = list1.get(0);
        return ans;
    }
    //第二种方法，异或（相同为零，不同为一）
    //一个数和0进行异或，结果是其本身
    public static char findDifference2(String s, String t) {
        char ans = 0;
        for(int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++) {
            ans ^= t.charAt(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.print(findTheDifference("abcd", "acbde"));
        System.out.println(findDifference2("adc", "cdda"));
    }
}
