package day_21.prms_42576;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }

        return null;
    }
}
