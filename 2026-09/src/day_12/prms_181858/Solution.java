package day_12.prms_181858;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        boolean[] seen = new boolean[1 + 100000];
        int[] ans = new int[k];
        Arrays.fill(ans, -1);

        int idx = 0;
        for (int x : arr) {
            if (seen[x]) continue;
            ans[idx++] = x;
            seen[x] = true;

            if (idx == k) break;
        }

        return ans;
    }
}
