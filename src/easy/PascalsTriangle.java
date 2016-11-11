package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeffrey on 2016/11/11.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows <= 0) {
            return triangle;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        for(int i = 1; i < numRows; i++) {
            List<Integer> lastRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>(i + 1);
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    currentRow.add(1);
                }else {
                    currentRow.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            triangle.add(currentRow);
        }
        return triangle;
    }
}
