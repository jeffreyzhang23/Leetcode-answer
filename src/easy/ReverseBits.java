package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeffrey on 2016/11/29.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    /**
     * 只需要把要翻转的数从右向左一位位的取出来，然后加到新生成的数的最低位即可
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res = (res << 1) ^ ((n >>> i) & 1);
        }
        return res;
    }
    /**
     * O(1) Time, O(1) Space
     * Divide 32 bits into 4 bytes
     * Cache each byte and its reversed result in a hashmap
     * Check cache for result first instead of computing all
     */
    private Map<Byte, Integer> cache = new HashMap<>();
    public int reverseBits1(int n) {
        byte[] bytes = new byte[4];
        for(int i = 0; i < 4; i++) {
            bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);
        }
        int res = 0;
        for(int i = 0; i < 4; i++) {
            res = (res << 8) ^ reverseBytes(bytes[i]);
        }
        return res;
    }
    public int reverseBytes(byte b) {
        if(cache.containsKey(b))
            return cache.get(b);
        int res = 0;
        for(int i = 0; i < 8; i++) {
            res = (res << 1) ^ ((b >>> i) & 1);
        }
        cache.put(b, res);
        return res;
    }

}
