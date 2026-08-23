package day_24.prms_181923;

import java.util.*;

class Solution {

    static int INF = 1_000_001;

    public int[] solution(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, INF);

        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            for (int j = s; j <= e; j++) {
                if (arr[j] > k && arr[j] < ans[i]) ans[i] = arr[j];
            }

            if (ans[i] == INF) ans[i] = -1;
        }

        return ans;
    }
}
