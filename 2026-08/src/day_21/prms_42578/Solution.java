package day_21.prms_42578;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String[] c : clothes) {
            cnt.put(c[1], cnt.getOrDefault(c[1], 0) + 1);
        }

        int ans = 1;
        for (int v : cnt.values()) {
            ans *= v + 1;
        }

        return ans - 1;
    }
}
