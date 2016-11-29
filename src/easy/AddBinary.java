package easy;

/**Given two binary strings, return their sum (also ab binary string).
 * <p>
 * For example,
 * ab = "11"
 * b = "1"
 * Return "100".
 * <p>
 * Company Tags: Facebook
 * Tags: Math, String
 * Similar Problems: (M) Add Two Numbers, (M) Multiply Strings, (E) Plus One
 * Created by Jeffrey on 2016/11/29.
 */
public class AddBinary {
    /**
     *  Math. String.
     * Initialize two pointers i and j at the end of a and b.
     * Use one integer c for the carry.
     * While i >= 0 or j >= 0 or c == 1:
     * | Add char in a or 0 to carry c. Move i.
     * | Add char in b or 0 to carry c. Move j.
     * | c % 2 is the current digit.
     * | Insert current digit to the front of result.
     * | c / 2 is the next carry.
     * Return result string.
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        StringBuilder sb = new StringBuilder();
        while(i >=0 || j >= 0 || c == 1) {
            c += (i >= 0 ? a.charAt(i--) - '0' : 0);
            c += (j >= 0 ? b.charAt(j--) - '0' : 0);
            sb.insert(0, c % 2);
            c >>= 1;
        }
        return sb.toString();
    }
    public String addBinary1(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < m || i < n) {
            int p = i < m ? a.charAt(m - 1 - i) - '0' : 0;
            int q = i < n ? b.charAt(n - 1 - i) - '0' : 0;
            int temp = p + q + carry;
            carry = temp / 2;
            sb.insert(0, temp % 2);
            i++;
        }
        return carry == 0 ? sb.toString() : "1" + sb.toString();
    }
}
