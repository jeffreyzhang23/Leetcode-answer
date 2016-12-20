package easy;

/**A sequence of number is called arithmetic if it consists of at least three elements
 * and if the difference between any two consecutive elements is the same.
 *
 * For example, these are arithmetic sequence:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 *
 * The following sequence is not arithmetic. 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is
 * any pair of integers (P, Q) such that 0 <= P < Q < N.
 *
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 *     A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means
 * that  P + 1 < Q.
 *
 * The function should return the number of arithmetic slices in the array A.
 *
 * Example:
 *
 * A = [1, 2, 3, 4]
 *
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4]
 * itself.
 * Created by Jeffrey on 2016/12/20.
 */
public class ArithmeticSlices {
    /**
     * It's easy to find out how many 3-length slices in an arithmetic array with N length.

     len = 3, then  1 slices, sum(1)
     len = 4, then  3 slices, sum(1,2) - TWO 3-length slices + ONE 4-length slice
     len = 5, then  6 slices, sum(1,2,3) - THREE 3-length slices + TWO 4-length slices + ONE 5-length slice
     len = 6, then 10 slices, sum(1,2,3,4) - ...
     len = 7, then 15 slices, sum(1,2,3,4,5) - ..

     So, with N length arithmetic array, there are Sum[1, N-3+1] 3-length slices

     And, we know the formula sum from 1 to n is:

                   n * ( n + 1 )
     sum [1, n] = ---------------
                        2
     Then, we could have the solution - O(n) Time with O(1) Space
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        int len = 0; // the current length of arithmetic
        for(int i = 2; i < A.length; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                len++;
            } else {
                result += sum1ToN(len);
                len = 0;
            }
        }
        return len == 0 ? result : result + sum1ToN(len);
    }
    public int sum1ToN(int n) {
        return n * (n + 1) / 2;
    }
}
