package easy;

/**258. Add Digits
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * <p>
 * Hint:
 * <p>
 * 1. A naive implementation of the above process is trivial. Could you come up with other methods?
 * 2. What are all the possible results?
 * 3. How do they occur, periodically or randomly?
 * 4. You may find this Wikipedia article(https://en.wikipedia.org/wiki/Digital_root) useful.
 * <p>
 * Tags: Math
 * Similar Problems: (E) Happy Number
 * Created by Jeffrey on 2016/9/8.
 */
public class AddDigits {
    /**
     * Possible results range from 0 to 9.
     * Only when num is 0, the result is 0; Otherwise, the result is within 1 to 9.
     * It happens periodically as the num increases one by one.
     */
    static int addDigits(int n) {
        if(n == 0) return 0;
        return n % 9 == 0 ? 9 : n % 9;
    }
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
