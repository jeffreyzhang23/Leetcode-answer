package easy;

/**
 * Created by Jeffrey on 2016/10/25.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;
        while(num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
            if(num % 2 == 0) num /= 2;
            else if(num % 3 == 0) num /= 3;
            else if(num % 5 == 0) num /= 5;
            if(num == 1 || num == 2 || num == 3 || num == 5)
                return true;
        }
        return false;
    }
}
