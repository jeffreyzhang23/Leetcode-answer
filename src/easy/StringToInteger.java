package easy;

/**Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 *
 *  Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * Tags: Math, String
 * Created by Jeffrey on 2016/12/13.
 */
public class StringToInteger {
    public static int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        // remove front and trailing whitespaces
        str = str.trim();
        //isNegative or not
        boolean isNegative = false;
        long res = 0;
        if(str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1, str.length());
        } else if(str.charAt(0) == '+') {
            str = str.substring(1, str.length());
        }
        System.out.println(str);
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                if(isNegative) {
                    if(res * -1 <= Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;
                }
                if(res > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            } else
                break;
        }
        res = isNegative ? res * (-1) : res;
        return (int) res;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
    }
}
