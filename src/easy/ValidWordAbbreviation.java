package easy;

/**Given a non-empty string s and an abbreviation abbr, return whether the string matches
 * with the given abbreviation.
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2",
 * "2r1", "3d", "w3", "4"]
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any
 * other string is not a valid abbreviation of "word".
 *
 * Note:
 * Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 *
 * Example 1:
 * Given s = "internationalization", abbr = "i12iz4n":
 * Return true.
 *
 * Example 2:
 * Given s = "apple", abbr = "a2e":
 * Return false.
 *
 * Created by Jeffrey on 2016/12/1.
 *
 */
public class ValidWordAbbreviation {
    /**
     * 定义两个指针，分别指向word和abbr的开头，循环条件是指针没到达各自的末尾。指向abbr的指针如果指向0，则返回false；
     * 如果指向1~9的数字，则用while循环把数字整体取出，指向word的单词向后移动相应位；如果指向字母，则比较两个指针指向字母是否相同，不同返回false,
     * 两个指针后移一位。
     * 注意：连续的digit要组成一个number。
     * @param word
     * @param abbr
     * @return
     */
    public static boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || word.length() == 0)
            return false;
        int i = 0;
        int j = 0;
        int m = word.length();
        int n = abbr.length();
        while(i < m && j < n) {
            if(abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                if(abbr.charAt(j) == '0') {
                    return false;
                }
                int val = 0;
                while(j < n && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    val = val * 10 + abbr.charAt(j++) - '0';
                }
                i += val;
            } else {
                if(word.charAt(i++) != abbr.charAt(j++)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
    }
}
