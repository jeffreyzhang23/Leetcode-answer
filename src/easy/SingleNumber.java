package easy;

/**136.Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 *
 * This is classical interview question
 // As we know, the same number XOR together will be 0,
 // So, XOR all of numbers, the result is the number which only appears once.
 *
 *
 * Created by Jeffrey on 2016/9/8.
 */

public class SingleNumber {
    static int singleNumber(int[] a) {
        int s = 0;
        for(int i = 0; i < a.length; i++) {
            s = s ^ a[i];
        }
        return s;
    }
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 2};
        System.out.println(singleNumber(a));
    }
}
