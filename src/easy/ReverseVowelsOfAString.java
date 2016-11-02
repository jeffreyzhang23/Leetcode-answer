package easy;

/**
 * Created by Jeffrey on 2016/11/2.
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if(s == null || s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder(s);
        String vowels = "aeiouAEIOU";
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            while(i < j && vowels.indexOf(s.charAt(i)) == -1) {i++;}
            while(i < j && vowels.indexOf(s.charAt(j)) == -1) {j--;}
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, c);
            i++;
            j--;
        }
        return sb.toString();
    }
}
