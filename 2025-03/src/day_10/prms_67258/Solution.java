package day_10.PRMS_67258;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }

        Map<String, Integer> map = new HashMap<>();
        int left = gems.length - 1;
        int right = gems.length - 1;
        int len = gems.length;
        int[] ans = new int[2];

        while (true) {
            while (left >= 0 && map.size() != set.size()) {
                map.put(gems[left], map.getOrDefault(gems[left], 0) + 1);

                left--;
            }

            while (right >= 0 && map.size() == set.size()) {
                if (map.get(gems[right]) == 1) map.remove(gems[right]);
                else map.put(gems[right], map.get(gems[right]) - 1);

                right--;
            }

            if (right - left <= len) {
                ans[0] = left + 2;
                ans[1] = right + 2;
                len = right - left;
            }

            if (left == -1) break;
        }

        return ans;
    }
}
