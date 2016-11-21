package easy;

import java.util.HashMap;
import java.util.Map;

/**Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 * Tags: Hash Table
 * Similar Problems: (E) Isomorphic Strings (H) Word Pattern II
 * Created by Jeffrey on 2016/11/21.
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Object, Integer> map = new HashMap<>(pattern.length());

        for (Integer i = 0; i < words.length; i++) { // use Integer to avoid autoboxing-same-value-to-different-objects-problem
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                // check previous put value
                /**
                 * public V put(K key,V value)
                 * Returns:
                 * the previous value associated with key, or null if there was no mapping for key.
                 */
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
