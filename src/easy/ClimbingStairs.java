package easy;

/**
 * Created by Jeffrey on 2016/10/25.
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n < 0) return -1;
        if(n == 0 || n == 1) return 1;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for(int i = 2; i < cache.length; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}
