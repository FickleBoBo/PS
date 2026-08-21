package day_21.prms_42578;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        int ans = 1;
        for (int v : map.values()) {
            ans *= v + 1;
        }

        return ans - 1;
    }
}
