package easy;

/**Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * <p>
 * Company Tags: Microsoft, Facebook, Zenefits
 * Tags: Math
 * Similar Problems: (E) Excel Sheet Column Number
 * Created by Jeffrey on 2016/12/9.
 */
public class ExcelSheetColumnTitle {
    /**
     * Iterative.
     * Map 0 to A, 1 to B, ..., 25 to Z.
     * So we need to decrease n by 1 first.
     * For each iteration, reduce n by 1.
     * Insert the result to the head of the StringBuilder.
     * Then n / 26 to get the number for next iteration.
     * Stop when n is 0.
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        if(n <= 0)
            return null;
        char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                                    'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n--;
            sb.insert(0, chars[n % 26]);
            n /= 26;
        }
        return sb.toString();
    }

    /**
     * Iterative.
     * Map 0 to A, 1 to B, ..., 25 to Z.
     * So we need to decrease n by 1 first.
     * For each iteration, reduce n by 1.
     * Convert n to a character and add to result.
     * Then n / 26 to get the number for next iteration.
     * Stop when n is 0.
     * @param n
     * @return
     */
    public String convertToTitle1 (int n) {
        if(n <= 0)
            return null;
        StringBuilder res = new StringBuilder();
        while(n > 0) {
            n--; //Offset. Map 0 to A, 1 to B .. 25 to Z instead.
            res.append((char)('A' + n % 26));
            n /= 26;
        }
        return res.reverse().toString();
    }

    /**
     * Recursive.
     * Recurrence relation:
     * Convert the rest of the characters + Convert current char.
     * Base case:
     * n <= 0, return abn empty string.
     * @param n
     * @return
     */
    public String convertToTitle2(int n) {
        return n <= 0 ? "" : convertToTitle2(--n / 26) + (char)('A' + n % 26);
    }
    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(53));
    }
}
