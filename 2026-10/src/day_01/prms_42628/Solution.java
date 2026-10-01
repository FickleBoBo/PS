package day_01.prms_42628;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            int x = Integer.parseInt(parts[1]);

            if (parts[0].equals("I")) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            } else {
                if (map.isEmpty()) continue;

                int key = (x == 1) ? map.lastKey() : map.firstKey();
                int cnt = map.get(key);
                if (cnt == 1) {
                    map.remove(key);
                } else {
                    map.put(key, cnt - 1);
                }
            }
        }

        if (map.isEmpty()) return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}
