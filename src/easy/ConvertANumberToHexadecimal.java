package easy;

/**
 * @author jeffrey0110 2016/10/18
 */
public class ConvertANumberToHexadecimal {
	public static String toHex(int num) {
		if(num == 0) return "0";
		int mask = 15; //0xf
		StringBuilder sb = new StringBuilder();
		while(num != 0) {
			int index = num & mask;
			char c = (char) (index < 10 ? (index + '0') : ('a' + index - 10));
			sb.append(c);
			num >>>= 4; // unsigned right shift, if use the ">>", when num is negative, the program is never stopped(the top digit is always 1).
		}
		sb.reverse();
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(toHex(0));
	}
}
