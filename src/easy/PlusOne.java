package easy;

import java.util.Arrays;

/**Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Created by Jeffrey on 2016/11/3.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int count = digits.length;
        while(count > 0) {
            digits[count - 1] = digits[count - 1] + 1;
            if(digits[count - 1] > 9)
                digits[count - 1] = 0;
            else
                return digits;
            count--;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for(int i = 1; i < result.length; i++) {
            result[i] = 0;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = new int[]{9, 9};
        System.out.println(Arrays.toString(plusOne(array)));
    }
}
