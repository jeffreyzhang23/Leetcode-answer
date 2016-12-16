package easy;

import java.util.Arrays;

/**Count the number of segments in a string, where a segment is defined to be a contiguous
 *  sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.

 Example:

 Input: "Hello, my name is John"
 Output: 5


 * Created by Jeffrey on 2016/12/15.
 */
public class NumberOfSegmentsInAString {
    /**
     * 注意审题，空格分开就算是一段。
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                if(i == 0) {
                    count++;
                } else if(i > 0 && s.charAt(i - 1) == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

}
