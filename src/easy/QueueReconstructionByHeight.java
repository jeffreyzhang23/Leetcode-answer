package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**Suppose you have a random list of people standing in a queue. Each person is described by a pair of
 * integers (h, k), where h is the height of the person and k is the number of people in front of this
 * person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * Tags: Greedy
 * Similar Problems: (H) Count of Smaller Numbers After Self
 * Created by Jeffrey on 2016/12/20.
 */
public class QueueReconstructionByHeight {
    /**
     * Sort the array by height descending and k ascending.
     * Pick the highest people from the array.
     * Then pick the second highest from the array and insert to result according to k.
     * Repeat till there is no more people.
     * <p>
     * If k means the # of people in front of him that are shorter or equal.
     * We should sort by height ascending and k asceding instead.
     */
    /**
     * // For example:
     // Original Queue:  [7,0], [4,4], [7,1], [5,0], [6,1], [5,2]
     //   Sorted Queue:  [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]


     // Why do we need to sort like this?
     //
     //     ** The position of shorter people is ZERO impacted with higher people. **
     //
     // and, the shortest people has no impacts to all of people. we can simpley insert it to the Kth position
     //
     // So, we sorted the people from highest to the shortest, then when we insert the people to another array,
     //
     // we always can guarantee the people is going to be inserted has nothing to do with the people has been inserted.
     //
     // Let's continue the about example above
     //
     //    [7,0] => []                                then [7,0]
     //    [7,1] => [7,0]                             then [7,0], [7,1]
     //    [6,1] => [7,0], [7,1]                      then [7,0], [6,1], [7,1]
     //    [5,0] => [7,0], [6,1], [7,1]               then [5,0], [7,0], [6,1], [7,1]
     //    [5,2] => [5,0], [7,0], [6,1], [7,1]        then [5,0], [7,0], [5,2], [6,1], [7,1]
     //    [4,4] => [5,0], [7,0], [5,2], [6,1], [7,1] then [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
     //
     // We alway can see, the people is going to be inserted has NO IMPACT with the current people.
     //
     //    [6,1] => [7,0], [7,1]
     //
     //    Whatever the people[6,1] placed, it has nothing to do with the people [7,0] [7,1],
     //    So, we can just insert the people to the place he like - the `Kth` place.
     //
     //
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0] == 0 ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[0][0]);
    }
}
