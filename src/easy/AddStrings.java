package easy;

import sun.applet.Main;
/**
 * 
 * @author jeffrey0110 2016/10/18
 *
 */
public class AddStrings {
	public static String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;
		int carry = 0;
		while(index1 >= 0 && index2 >= 0) {
			int a = num1.charAt(index1--) - '0';
			int b = num2.charAt(index2--) - '0';
			int bitSum = (a + b + carry) % 10;
			carry = (a + b + carry) / 10;
			sb.insert(0, bitSum);
 		}
		while(index1 >= 0) {
			int a = num1.charAt(index1--) - '0';
			int bitSum = (a + carry) % 10;
			carry = (a + carry) / 10;
			sb.insert(0, bitSum);
		}
		while(index2 >= 0) {
			int b = num2.charAt(index2--) - '0';
			int bitSum = (b + carry) % 10;
			carry = (b + carry) / 10;
			sb.insert(0, bitSum);
		}
		if(carry == 1) 
			sb.insert(0, 1);
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(addStrings("9", "99"));
	}
	
}
