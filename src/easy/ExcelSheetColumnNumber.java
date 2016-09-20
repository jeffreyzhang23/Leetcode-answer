package easy;

/**
 * Created by Jeffrey on 2016/9/19.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - '@');
        }
        return res;
    }
}
