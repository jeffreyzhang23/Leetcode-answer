package easy;

import java.util.ArrayList;
import java.util.List;

/**Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 *
 * Return [1,3,3,1].
 *
 * Created by Jeffrey on 2016/11/14.
 */
public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        if(rowIndex < 0)
            return firstRow;
        firstRow.add(1);
        if(rowIndex == 0)
            return firstRow;
        triangle.add(firstRow);
        for(int i = 1; i < rowIndex + 1; i++) {
            List<Integer> lastRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    currentRow.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            triangle.add(currentRow);
        }
        return triangle.get(rowIndex);
    }
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
