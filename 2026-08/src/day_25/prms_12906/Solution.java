package day_25.prms_12906;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int prv = -1;

        for (int x : arr) {
            if (x == prv) continue;
            list.add(x);
            prv = x;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
