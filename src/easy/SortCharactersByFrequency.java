package easy;

import java.util.*;

/**Given a string, sort it in decreasing order based on the frequency of characters.
 * Example 1:

 Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 Example 2:

 Input:
 "cccaaa"

 Output:
 "cccaaa"

 Explanation:
 Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 Note that "cacaca" is incorrect, as the same characters must be together.
 Example 3:

 Input:
 "Aabb"

 Output:
 "bbAa"

 Explanation:
 "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.
 * Created by Jeffrey on 2016/12/26.
 */
public class SortCharactersByFrequency {
    /**
     * 用hashmap，分别统计各个字母出现的次数，将键值对按值进行降序排列，最后根据字母出现次数取出对应的键值即可。
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        if(s == null)
            return null;
        if(s.length() == 0)
            return "";
        Map<Character, Integer> res = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(res.containsKey(s.charAt(i))) {
                res.put(s.charAt(i), res.get(s.charAt(i)) + 1);
            } else {
                res.put(s.charAt(i), 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(res.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(Map.Entry<Character, Integer> entry : list) {
            int num = entry.getValue();
            do {
                sb.append(entry.getKey());
            } while (num-- > 1);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        frequencySort("Aabb");
        frequencySort("tree");
        frequencySort("cccaaa");
    }
}
