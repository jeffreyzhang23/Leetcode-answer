package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word
 * abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's
 abbreviation is unique if no other word from the dictionary has the same abbreviation.

 Example:

 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true
 * Created by Jeffrey on 2016/12/13.
 */
public class UniqueWordAbbreviation {
    private static HashMap<String, List<String>> map = new HashMap<>();
    public static void validWordAbbr(String[] dictionary) {
        for(String s : dictionary) {
            String key = s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
            if(map.containsKey(key)) {
                map.get(key).add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
    }
    public static boolean isUnique(String word) {
        String key = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        if(!map.containsKey(key)) {
            return true;
        }else if(map.get(key).size() < 2 && map.get(key).get(0).equals(word))
                return true;
        return false;
    }
    public static void main(String[] args) {
        validWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(isUnique("dear"));
        System.out.println(isUnique("cart"));
    }
}
