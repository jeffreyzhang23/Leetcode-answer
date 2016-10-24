package easy;
/**
 * 
 * @author jeffrey0110 2016/10/18
 *
 */
public class PowerOfThree {
	//double x = Math.log(5); => x = ln5;
	//logx(y) = loge(x) / loge(y)
	public static boolean isPowerOfThree1(int n) {
		double result = Math.log(n) / Math.log(3);
		return (result - (int)(result) == 0);
	}
	public static boolean isPowerOfThree2(int n) {
		return n > 0 ? (1162261467 % n == 0) : false;
	}
	public static boolean isPowerOfThree3(int n) {
		for(; n > 0; n /= 3) {
			if(n == 1 || n == 3) return true;
			if(n % 3 != 0) return false;
		}
		return false;
	}
	public static boolean isPowerOfThree4(int n) {
		if(n == 1 || n == 3) return true;
		if(n == 0 || n % 3 != 0) return false;
		return isPowerOfThree4(n / 3);
	}
	public static void main(String[] args) {
		System.out.println(isPowerOfThree1(3));
	}
}
