package easy;

/**
 * Created by Jeffrey on 2016/9/27.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int res = 0;
        if(s == null || s.length() == 0)
            return 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M':
                    res += 1000;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'I':
                    res += 1 * (res >= 5 ? -1 : 1);
                    break;
            }
        }
        return res;
    }
}
