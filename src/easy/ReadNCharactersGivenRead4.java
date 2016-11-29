package easy;

/**The API: int read4(char *buf) reads 4 characters at a time from a file.
 * <p>
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters
 * left in the file.
 * <p>
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * <p>
 * Note:
 * The read function will only be called once for each test case.
 * <p>
 * Company Tags: Facebook
 * Tags: String
 * Similar Problems: (H) Read N Characters Given Read4 II - Call multiple times
 * Created by Jeffrey on 2016/11/29.
 */
public class ReadNCharactersGivenRead4 {
    /**
     * Dummy
     */
    private class Reader4 {
        int read4(char[] buf) {
            return 0;
        }
    }
    public class Solution extends Reader4 {
        /**
         * 思路：就是每次read4只能读一次，然后根据count决定是否加入buf，注意考虑读出来的是0，则直接break，不读了。
         *
         * @param buf Destination buffer
         * @param n Maximum number of characters to read
         * @return The number of characters read
         */
        int read4(char[] buf, int n) {
            int count = 0;
            char[] myBuf = new char[4];
            while(count < n) {
                int num = read4(myBuf);
                if(num == 0)
                    break;
                int index = 0;
                while(index < num && count < n) {
                    buf[count++] = myBuf[index++];
                }
            }
            return count;
        }
    }
}
