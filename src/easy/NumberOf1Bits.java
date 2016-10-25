package easy;

/**
 * Created by Jeffrey on 2016/10/25.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
