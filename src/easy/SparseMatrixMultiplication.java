package easy;

/**Given two sparse matrices A and B, return the result of AB.
 * <p>
 * You may assume that A's column number is equal to B's row number.
 * <p>
 * Example:
 * <p>
 * | A = [
 * |   [ 1, 0, 0],
 * |   [-1, 0, 3]
 * | ]
 * <p>
 * | B = [
 * |   [ 7, 0, 0 ],
 * |   [ 0, 0, 0 ],
 * |   [ 0, 0, 1 ]
 * | ]
 * <p>
 * |      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * | AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 * |                   | 0 0 1 |
 * Company Tags: LinkedIn, Facebook
 * Tags: Hash Table
 * Created by Jeffrey on 2016/12/27.
 */
public class SparseMatrixMultiplication {
    /**
     * Matrix multiplication is row in A multiply column in B.
     * When implement, for A[i][j], multiply a row B[j][k], 0 <= k < nB.
     * Then add result to res[i][k].
     * Skip zeros since the matrix is sparse.
     * <p>
     * Loop through A from left to right, row by row.
     * In each row, multiply the column value A[i][j] with each value in row j in B, B[j][k].
     * Add it to res[i][k].
     * @param A
     * @param B
     * @return
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int mA = A.length;
        int nA = A[0].length;
        int nB = B[0].length;
        int[][] res = new int[mA][nB];
        for(int i = 0; i < mA; i++) {
            for(int j = 0; j < nA; j++) {
                if(A[i][j] == 0)
                    continue;
                for(int k = 0; k < nB; k++) {
                    if(B[i][k] == 0)
                        continue;
                    res[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return res;
    }
}
