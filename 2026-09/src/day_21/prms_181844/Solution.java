package day_21.prms_181844;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        boolean[] seen = new boolean[1 + 1000];
        for (int x : delete_list) {
            seen[x] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            if (!seen[x]) list.add(x);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
