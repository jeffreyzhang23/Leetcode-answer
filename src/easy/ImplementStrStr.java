package easy;

/**Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Company Tags: Pocket Gems, Microsoft, Apple, Facebook
 * Tags: Two Pointers, String
 * Similar Problems: (H) Shortest Palindrome
 * Created by Jeffrey on 2016/12/2.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() == 0)
            return 0;
        for(int i = 0; i < haystack.length(); i++) {
            if(i + needle.length() > haystack.length())
                return -1;
            for(int j = 0; j < needle.length(); j++) {
                if(needle.charAt(j) == haystack.charAt(i + j)) {
                    if(j == needle.length() - 1)
                        return i;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
