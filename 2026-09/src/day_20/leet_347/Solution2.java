package day_20.leet_347;

import java.util.*;

class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        int len = nums.length;
        List<Integer>[] buckets = new ArrayList[1 + len];
        for (int i = 1; i <= len; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = len; i > 0; i--) {
            list.addAll(buckets[i]);
        }

        return list.stream().limit(k).mapToInt(Integer::intValue).toArray();
    }
}
