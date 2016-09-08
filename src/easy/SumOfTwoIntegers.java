package easy;

/**
 * Created by Jeffrey on 2016/9/8.
 */
public class SumOfTwoIntegers {
    static int getSum(int a, int b) {
        if(b == 0) return a;
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
    static int getSumRecursive(int a, int b) {
        if(b == 0) return a;
        return getSumRecursive(a ^ b, (a & b) << 1);
    }
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSumRecursive(2, 3));
    }
}
