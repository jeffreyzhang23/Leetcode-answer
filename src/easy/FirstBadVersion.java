package easy;

/**You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
 * your product fails the quality check. Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
 * ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
 * find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Company Tags: Facebook
 * Tags: Binary Search
 * Similar Problems: (M) Search for a Range, (M) Search Insert Position, (E) Guess Number Higher or Lower
 * Created by Jeffrey on 2016/12/12.
 */
public class FirstBadVersion {
    /**
     * Binary Search.
     * Initial search range:
     * n versions from 1 to n.
     * Get the middle version m.
     * If m is bad, then m+1 to n are all bad. The first bad version can be m or previous versions.
     * If m is good, the first bad version can only be larger than m.
     * Stop when there is only one version left.
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l < r) {
            int m = l + (r - 1) / 2; // Avoid overflow, since l >= 1, n <= Integer.MAX_VALUE
            if(!isBadVersion(m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    /**
     * Dummy function, just for compilation.
     */
    public boolean isBadVersion(int m) {
        return m > 1;
    }
}
