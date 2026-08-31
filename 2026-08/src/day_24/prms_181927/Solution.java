package day_24.prms_181927;

import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int[] ans = Arrays.copyOf(num_list, n + 1);

        if (num_list[n - 1] > num_list[n - 2]) {
            ans[n] = num_list[n - 1] - num_list[n - 2];
        } else {
            ans[n] = num_list[n - 1] * 2;
        }

        return ans;
    }
}
