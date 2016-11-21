package easy;

/**Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No
 * two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 * Created by Jeffrey on 2016/11/16.
 * Tags: Hash Table
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] mapS = new char[256];
        char[] mapT = new char[256];
        for(int i = 0; i < s.length(); i++) {
            if(mapS[s.charAt(i)] == 0 && mapT[t.charAt(i)] == 0) {
                mapS[s.charAt(i)] = t.charAt(i);
                mapT[t.charAt(i)] = s.charAt(i);
                continue;
            }
            if(mapS[s.charAt(i)] == t.charAt(i) && mapT[t.charAt(i)] == s.charAt(i)) {
                continue;
            }
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("aa", "aa"));
    }
}
