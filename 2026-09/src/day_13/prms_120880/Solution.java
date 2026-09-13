package day_13.prms_120880;

import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int len = numlist.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = Math.abs(n - numlist[i]);
            arr[i][1] = numlist[i];
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o2[1], o1[1]);
        });

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = arr[i][1];
        }

        return ans;
    }
}
