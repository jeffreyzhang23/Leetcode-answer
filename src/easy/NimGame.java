package easy;

/**
 * Created by Jeffrey on 2016/9/8.
 */
public class NimGame {
    static boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
    public static void main(String[] args) {
        int n = 5;
        canWinNim(5);
    }
}
