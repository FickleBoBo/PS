package day_12.prms_181859;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int idx = 0;

        for (int x : arr) {
            if (idx == 0) {
                stk[idx++] = x;
            } else {
                if (stk[idx - 1] == x) {
                    idx--;
                } else {
                    stk[idx++] = x;
                }
            }
        }

        if (idx == 0) return new int[]{-1};
        return Arrays.copyOf(stk, idx);
    }
}
