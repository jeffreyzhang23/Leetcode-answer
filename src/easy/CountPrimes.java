package easy;

import java.util.Arrays;

/**Description:
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.
 *
 * Let's start with a isPrime function. To determine if a number is prime, we need to check if
 * it is not divisible by any number less than n. The runtime complexity of isPrime function
 * would be O(n) and hence counting the total prime numbers up to n would be O(n2). Could we do better?
 * Created by Jeffrey on 2016/12/6.
 */
public class CountPrimes {
    /**
     * Sieve of Eratosthenes
     * 埃拉托斯特尼筛法，可以用以下的伪代码来表示：
     * Input: an integer n > 1
     * Let A be an array of Boolean values, indexed by integers 2 to n,
     * initially all set to true.
     * for i = 2, 3, 4, ..., not exceeding √n:
     * if A[i] is true:
     * for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n :
     * A[j] := false
     * Output: all i such that A[i] is true.
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrimer = new boolean[n];
        Arrays.fill(isPrimer, true);
        for(int i = 2; i * i < n; i++) {
            if(isPrimer[i]) {
                for(int j = i * i; j < n; j += i) {
                    isPrimer[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrimer[i])
                count++;
        }
        return count;
    }
}
