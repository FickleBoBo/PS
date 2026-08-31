package day_29.prms_181894;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        int s = 0, e = n - 1;

        while (s < n && arr[s] != 2) {
            s++;
        }
        if (s == n) return new int[]{-1};

        while (arr[e] != 2) {
            e--;
        }

        return Arrays.copyOfRange(arr, s, e + 1);
    }
}
