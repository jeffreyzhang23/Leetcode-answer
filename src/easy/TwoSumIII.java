package easy;

import java.util.HashMap;

/** Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * For example,
 *
 *   add(1); add(3); add(5);
 *   find(4) -> true
 *   find(7) -> false
 * Created by Jeffrey on 2016/12/12.
 */
public class TwoSumIII {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    public void add(int a) {
        if(hashMap.containsKey(a)) {
            hashMap.put(a, hashMap.get(a) + 1);
        } else {
            hashMap.put(a, 1);
        }
    }
    public boolean find(int value) {
        for(Integer i : hashMap.keySet()) {
            int target = value - i;
            if(hashMap.containsKey(target)) {
                if(i == target && hashMap.get(target) < 2)
                    continue;
                return true;
            }
        }
        return false;
    }
}
