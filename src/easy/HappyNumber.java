package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jeffrey0110
 */
public class HappyNumber {
	public static boolean isHappy(int n) {
		int slow, fast;
		slow = fast= n;
		do {
			slow = digitSquareSum(slow);
			fast = digitSquareSum(digitSquareSum(fast));
			System.out.println("slow = " + slow +", fast = " + fast);
		} while(slow != fast);
		return slow == 1;
    }
	public static boolean isHappy2(int n) {
		int num = n;
		Set<Integer> results = new HashSet<Integer>();
		while(!results.contains(num)) {
			results.add(num);
			num = digitSquareSum(num);
		}
		return num == 1;
	}
	public static int digitSquareSum(int n) {
		int res = 0;
		int digit;
		for(; n > 0; n /= 10 ) {
			digit = n % 10;
			res += digit * digit;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
}
