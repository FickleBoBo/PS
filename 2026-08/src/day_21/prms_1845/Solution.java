package day_21.prms_1845;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            seen.add(x);
        }

        return Math.min(seen.size(), nums.length / 2);
    }
}
