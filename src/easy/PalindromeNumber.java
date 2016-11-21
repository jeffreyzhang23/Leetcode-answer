package easy;

/**Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Created by Jeffrey on 2016/11/14.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10 && x >= 0) return true;
        String strNum = String.valueOf(Math.abs(x));
        System.out.println(strNum);
        int count = strNum.length() / 2;
        boolean result = true;
        for(int i = 0, j = strNum.length() - 1; i < count && j >= count; i++, j--) {
            result &= strNum.charAt(i) == strNum.charAt(j);
        }
        return result;
    }
    public boolean isPalindrome1(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int res = 0;
        while(res < x) {
            res = x % 10 + res * 10;
            x = x / 10;
        }
        return (x == res || (res / 10 == x));
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(123123));
    }
}
