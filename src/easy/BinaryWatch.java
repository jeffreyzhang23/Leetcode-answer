package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeffrey on 2016/9/26.
 */
public class BinaryWatch {
    public static List<String> solution(int num) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 12; i++)
            for(int j = 0; j < 60; j++)
                if(Integer.bitCount(i * 64 + j) == num)
                    list.add(String.format("%d:%02d", i, j));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
    }
}

