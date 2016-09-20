package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeffrey on 2016/9/18.
 */
public class RansomNote {
    static boolean canConstruct(String ransomNote, String magazine) {
        List<Character> list = new ArrayList<>();
        char[] ch1 = ransomNote.toCharArray();
        char[] ch2 = magazine.toCharArray();
        for(char ch : ch2)
            list.add(ch);
        for(Character ch : ch1) { // 迭代类型为Character而不是char，否则list.remove()会把ch当成索引。
            if(!list.contains(ch)) {
                return false;
            }
            list.remove(ch);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.print(canConstruct("a", "b"));
        System.out.print(canConstruct("aa", "ab"));
        System.out.print(canConstruct("aa", "aba"));
    }
}
