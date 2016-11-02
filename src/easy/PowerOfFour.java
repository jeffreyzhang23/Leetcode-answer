package easy;

/**
 * Created by Jeffrey on 2016/10/26.
 */
public class PowerOfFour {
    public static boolean isPowerOfFour(int num) {
        if(num < 1) return false;
        if(num == 1 || num == 4) return true;
        double res = Math.log(num) / Math.log(4);
        return (res - (int) res == 0);
    }
    public boolean isPowerOfFour2(int num) {
        if(num < 1) return false;
        if(num == 1 || num == 4) return true;
        for(; num > 0; num /= 4) {
            if(num == 1 || num == 4) return true;
            if(num % 4 != 0) return false;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(16));
    }
}
