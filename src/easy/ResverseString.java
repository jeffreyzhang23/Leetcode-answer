package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 344. Reverse String
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * @author Jeffrey
 *
 */

public class ResverseString {
	public static String reverseString(String s) {
		if(s == null || s.length() < 2) 
			return s;
		char[] ch = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char c = ch[i];
			ch[i] = ch[j];
			ch[j] = c;
			i++;
			j--;
		}
		return new String(ch);
	}
	
	public static String reverseStringB(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	/**
	 * bit manipulation
	 * @param s
	 * @return
	 */
	public static String reverseStringC(String s) {
		byte[] bytes = s.getBytes();
		int i = 0;
		int j = s.length() - 1;
		while(i < j) {
			bytes[i] = (byte) (bytes[i] ^ bytes[j]);
			bytes[j] = (byte) (bytes[i] ^ bytes[j]); //bytes[i] ^ bytes[j] ^ bytes[j] = bytes[i];
			bytes[i] = (byte) (bytes[i] ^ bytes[j]); //bytes[i] ^ bytes[j] ^ bytes[i] = bytes[j];
			i++;
			j--;
		}
		return new String(bytes);
	}
	
	public static String reverseStringD(String s) {
		int len = s.length();
		if(len <= 1) return s;
		String leftStr = s.substring(0, len / 2);	
		String rightStr = s.substring(len / 2, len);
		return reverseString(rightStr) + reverseString(leftStr);
	}
	
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(reverseString(s));
		System.out.println(reverseStringB(s));
		System.out.println(reverseStringC(s));
		System.out.println(reverseStringD(s));
	}
}
