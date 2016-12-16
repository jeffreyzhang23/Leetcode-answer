package easy;

import java.util.*;

/**
 * Created by Jeffrey on 2016/12/15.
 * Given a string, we can "shift" each of its letter to its successive letter, for example:
 * "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets, group all strings that
 belong to the same shifting sequence.

 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 Return:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]


 Note: For the return value, each inner list's elements must follow the lexicographic order.
 */
public class GroupShiftedStrings {
    /**
     * 对于输入数组中的每个字符串，将其“归零”，即求出该字符串对应的shifted squence
     * 中的第一个字符串（a为起始字符）。维护一个哈希表，key为各group的“零值”，value
     * 是输入数组中属于该group的字符串。
     * @param strings
     * @return
     */
    public List<List<String>> groupStrings(String[] strings) {
        if(strings == null || strings.length == 0)
            return null;
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strings) {
            char[] chars = s.toCharArray();
            if(chars.length > 0) {
                int diff = chars[0] - 'a';
                for(int i = 0; i < chars.length; i++) {
                    if(chars[i] - diff < 'a') {
                        chars[i] = (char) (chars[i] - diff + 26);
                    } else {
                        chars[i] = (char) (chars[i] - diff);
                    }
                }
            }
            String key = new String(chars);
            if(map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        result.addAll(map.values());
        return result;
    }
}
