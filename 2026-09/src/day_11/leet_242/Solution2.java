package day_11.leet_242;

import java.util.*;

class Solution2 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) - 1);
        }

        for (Map.Entry<Character, Integer> e : cnt.entrySet()) {
            if (e.getValue() != 0) return false;
        }

        return true;
    }
}
