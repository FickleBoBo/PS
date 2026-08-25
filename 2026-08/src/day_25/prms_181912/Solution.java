package day_25.prms_181912;

import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for (String str : intStrs) {
            int x = Integer.parseInt(str.substring(s, s + l));
            if (x > k) list.add(x);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
