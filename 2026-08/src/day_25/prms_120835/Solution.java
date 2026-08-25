package day_25.prms_120835;

import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (o1, o2) -> Integer.compare(emergency[o2], emergency[o1]));

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[idx[i]] = i + 1;
        }

        return ans;
    }
}
