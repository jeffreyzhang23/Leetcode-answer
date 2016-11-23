package easy;

/**Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m +
 * n) to hold additional elements from B. The number of elements initialized in
 * A and B are m and n respectively.
 *
 * Tags: Array
 * Created by Jeffrey on 2016/11/23.
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        while(m > 0 && n > 0) {
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
        while(n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
    }
}
