package easy;

import java.util.ArrayList;
import java.util.List;

/**Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger
 * than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Created by Jeffrey on 2016/11/14.
 */
public class FindAllAnagramsInAString {
    /**
     * Just use a sliding window, and record the different character numbers.
     * if the different numbers is 0, record it.
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] chars = new int[128];
        int[] sc = new int[128];
        for (int i = 0; i < p.length(); ++i) {
            chars[p.charAt(i)]++;
        }
        for (int i = 0; i < p.length() - 1; ++i) {
            if (chars[s.charAt(i)] > 0) {
                sc[s.charAt(i)]++;
            }
        }
        int diffNum = 0;
        for (int i = 'a'; i <= 'z'; ++i) {
            if (sc[i] != chars[i]) {
                diffNum += Math.abs(sc[i] - chars[i]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = p.length() - 1; i < s.length(); ++i) {
            char ch = s.charAt(i); // char to be added
            if (chars[ch] > 0) {
                diffNum += sc[ch] >= chars[ch] ? 1 : -1;
                sc[ch]++;
            }
            if (diffNum == 0) {
                result.add(i - p.length() + 1);
            }
            ch = s.charAt(i - p.length() + 1); // char to be deleted
            if (chars[ch] > 0) {
                diffNum += sc[ch] > chars[ch] ? -1 : 1;
                sc[ch]--;
            }
        }
        return result;
    }

    /**
     * 这道题，其实也就是要求从S中找到一个子串，这个子串变化后可以得到P（其实就是这个子串的26字母的分布和P一样）.所以自
     * 然而然的，我使用了最naïve的方式，就是直接滑动窗口（长度为P的大小），检查S的每一个子串的分布情况和P是否一样就可以了。
     * @param counter
     * @param temp
     * @return
     */
    public boolean check(int[] counter, int[] temp) {
        for(int i = 0; i < 26; i++) {
            if(counter[i] != temp[i])
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length())
            return result;
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        int[] counter = new int[26];
        int[] temp = new int[26];
        for(char c : P) {
            counter[c - 'a']++;
        }
        for(int i = 0; i < P.length; i++) {
            temp[S[i] - 'a']++;
        }
        if(check(counter, temp))
            result.add(0);
        for(int i = P.length; i < S.length; i++) {
            temp[S[i - P.length] - 'a']--;
            temp[S[i] - 'a']++;
            if(check(counter, temp))
                result.add(i - P.length + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
