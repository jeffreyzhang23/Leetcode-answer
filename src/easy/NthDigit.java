package easy;

/**Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 * 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n 31).
 *
 * Example 1:
 *
 * Input:
 * 3
 *
 * Output:
 * 3
 *
 * Example 2:
 *
 * Input:
 * 11
 *
 * Output:
 * 0
 *
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which
 * is part of the number 10.
 * Created by Jeffrey on 2016/11/28.
 */
public class NthDigit {
    /**
     * The solution of this problem is obvious when the following regularity is discovered.
     * 1 - 9  : 9
     * 10 - 99 : 90 * 2
     * 100 - 999 : 900 * 3
     * 1000 - 9999 : 9000 * 4
     * ... ...
     * For example given n is 1000, we first -9 and then -180. The left is 811. The number is
     * 100+810/3=370. The digit is the (810%3=0)th. Therefore, the digit is 3.
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        long m = n;
        long start = 1, len = 1, count = 9;
        while(m > len * count) {
            m = m - len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        start = start + (m - 1) / len;
        return String.valueOf(start).charAt((int)((m - 1) % len)) - '0';
    }
}
