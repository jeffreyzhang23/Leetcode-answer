package easy;

import java.util.Stack;

/**Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Company Tags: Microsoft, Uber, Facebook, Zenefits
 * Tags: Two Pointers, String
 * Similar Problems: (E) Palindrome Linked List
 * Created by Jeffrey on 2016/12/6.
 */
public class ValidPalindrome {
    /**
     * 从左到右遍历字符串，如果得到的字符是大小写字母或是数字则入栈，加入StringBuilder，直至遍历完成；
     * 只要栈不空，就弹出字符，将其加入新的StringBuilder。最后比较两个小写字符串是否相等。
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if((s.charAt(i) >= 48 && s.charAt(i) <= 57) ||
                    (s.charAt(i) >= 65 && s.charAt(i) <= 90) ||
                    (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
                sb.append(s.charAt(i));
                stack.push(s.charAt(i));
            }
        }
        while(!stack.isEmpty()) {
            sb1.append(stack.pop());
        }
        return sb.toString().toLowerCase().equals(sb1.toString().toLowerCase());
    }

    /**
     * Two pointers.
     * Ask for clarification:
     * What characters do we have for input? Space?
     * Case sensitive or not?
     * First convert the string to lowercase.
     * Then start from both ends and move pointers to the next alphanumeric character.
     * If these characters are not the same, return false.
     * Remember to move pointers one more step for the next round.
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {
        if(s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            if(i >= j) {
                return true;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
