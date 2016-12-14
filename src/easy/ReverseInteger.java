package easy;

/**Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Keys: Last digit is 0, Reversed integer might overflow
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if
 * you have already thought through this!
 *
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 *
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 *
 * Throw an exception? Good, but what if throwing an exception is not an
 * option? You would then have to re-design the function (ie, add an extra
 * parameter).
 *
 * Tags: Math
 * Created by Jeffrey on 2016/12/12.
 */
public class ReverseInteger {
    /**
     * Last digit is zero, output?
     * Reversed might overflow? 1000000003
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long res = 0;
        while(x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int) res;
    }
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
