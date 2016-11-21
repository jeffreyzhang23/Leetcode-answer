package easy;

/**The count-and-say sequence is the sequence of integers beginning as follows:1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * Note: brute way: loop string
 * Created by Jeffrey on 2016/11/21.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        for(int i = 1; i < n; i++) {
            result = countAndSayArray(result);
        }
        return result;
    }
    public String countAndSayArray(String cas) {
        int n = cas.length();
        int point = 0;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while(point < n) {
            while((point + count) < n && cas.charAt(point) == cas.charAt(point + count)) {
                count++;
            }
            sb.append(count + "");
            sb.append(cas.charAt(point) + "");
            point = point + count;
            count = 1;
        }
        return sb.toString();
    }
}
