package day_31.prms_120905;

import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<>();
        for (int x : numlist) {
            if (x % n == 0) list.add(x);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
