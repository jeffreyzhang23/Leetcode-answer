package easy;

import java.util.Stack;

/**Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * Created by Jeffrey on 2016/11/23.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if(c == ')') {
                if(stack.isEmpty())
                    return false;
                else {
                    if(stack.pop() != '(')
                        return false;
                }
            } else if(c == ']') {
                if(stack.isEmpty())
                    return false;
                else {
                    if(stack.pop() != '[')
                        return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty())
                    return false;
                else {
                    if(stack.pop() != '{')
                        return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValid("]"));
        System.out.println(isValid("(("));
        System.out.println(isValid("([])"));
    }
}
