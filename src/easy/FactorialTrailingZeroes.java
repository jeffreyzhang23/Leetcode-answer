package easy;

/**Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note: Your solution should be in logarithmic time complexity.
 *
 * Created by Jeffrey on 2016/11/14.
 */
public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int sum=0;
        int tmp=0;
        while(n/5>0)
        {
            tmp=n/5;
            sum+=tmp;
            n=tmp;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }
}
