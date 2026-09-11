package day_11.prms_181861;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            for (int i = 0; i < x; i++) {
                list.add(x);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
