package day_20.leet_49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            map.computeIfAbsent(sort(s), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    static String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
