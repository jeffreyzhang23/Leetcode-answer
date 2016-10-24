package easy;

/**
 * Created by Jeffrey on 2016/10/16.
 */
public class ConvertANumberToHexadecimal {

    public static String convertB(int num) {
        int mask = 15;
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            int index = (num & mask);
            char c = (char) ((index < 10) ? (index + '0') : ('a' + index - 10));
            sb.append(c);
            num = num >>> 4;
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String args[]) {
        System.out.println(convertB(26));
    }

}
