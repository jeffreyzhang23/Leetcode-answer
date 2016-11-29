package easy;

/**Write a function to find the longest common prefix string amongst an array
 * of strings.
 *
 * Tags: String
 * Created by Jeffrey on 2016/11/28.
 */
public class LongestCommonPrefix {
    /**
     * Find common prefix one by one from the end of the input string array
     * Overwrite the ith string with common prefix result
     * Thus space usage is reduced
     * Return first in group
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return null;
        if(strs.length == 0) return "";
        for(int i = strs.length - 2; i >= 0; i--) {
            strs[i] = commonPrefix(strs[i + 1], strs[i]);
        }
        return strs[0];
    }
    /**
     * Get length of two strings
     * Loop over each char till one length runs out
     * If same char, append it to result
     * If not same, break
     * Return result
     * @param a
     * @param b
     * @return
     */
    public String commonPrefix(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < a.length() && i < b.length()) {
            if(a.charAt(i) == b.charAt(i))
                sb.append(a.charAt(i));
            else
                break;
            i++;
        }
        return sb.toString();
    }
}
