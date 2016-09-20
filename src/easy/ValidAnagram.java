package easy;

import java.util.*;

/**
 * Created by Jeffrey on 2016/9/19.
 */
public class ValidAnagram {
    static boolean isAnagram(String s, String t) {
        List<Character> list = new ArrayList<>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        for(int i = 0; i < t.length(); i++) {
            if(!list.contains(t.charAt(i)))
                return false;
            list.remove((Character) t.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.print(isAnagram("anagram", "nagaram"));
    }
}
