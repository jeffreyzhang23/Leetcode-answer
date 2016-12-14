package easy;

import java.util.Arrays;

/**Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise
 * return 0.
 *
 * You may assume that the version strings are non-empty and contain only
 * digits and the . character.
 * The . character does not represent a decimal point and is used to separate
 * number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it
 * is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 * Tags: String
 * Created by Jeffrey on 2016/12/12.
 */
public class CompareVersionNumbers {
    /**
     * Compare each level and compare the rest
     * Note the input can be complex than the example, more dots, more zeros
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        if(version1 == null && version2 == null)
            return 0;
        if(version1 == null || version2 == null)
            return version1 == null ? -1 : 1;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
        int i = 0;
        while(i < v1.length || i < v2.length) {
            int a = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int b = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if(a < b)
                return -1;
            else if(a > b)
                return 1;
            i++;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(compareVersion("001.3.3.7.000", "1.3.3.7"));
    }
}
