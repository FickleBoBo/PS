package day_21.prms_42576;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> cnt = new HashMap<>();

        for (String p : participant) {
            cnt.put(p, cnt.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            cnt.put(c, cnt.getOrDefault(c, 0) - 1);
        }

        for (Map.Entry<String, Integer> e : cnt.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }

        return null;
    }
}
