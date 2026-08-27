package day_24.prms_181918;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int i = 0;
        int idx = 0;

        while (i < arr.length) {
            if (idx == 0 || stk[idx - 1] < arr[i]) {
                stk[idx++] = arr[i++];
            } else {
                idx--;
            }
        }

        return Arrays.copyOf(stk, idx);
    }
}
