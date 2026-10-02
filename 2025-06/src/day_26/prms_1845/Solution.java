package day_26.PRMS_1845;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 가장 많은 폰켓몬 종류의 수는 N/2 가지를 선택하되 map에 넣은 종류를 넘을 수 없음
        return Math.min(nums.length / 2, map.size());
    }
}
