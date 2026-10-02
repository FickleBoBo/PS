package day_10.PRMS_42861;

import java.util.*;

class Solution {

    private static int[] p;

    private static int[] make(int N) {
        int[] arr = new int[1 + N];
        for (int i = 1; i <= N; i++) arr[i] = i;
        return arr;
    }

    private static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    private static void union(int x, int y) {
        p[find(y)] = find(x);
    }

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        p = make(n);

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < costs.length; i++) {
            int[] e = costs[i];
            if (find(e[0]) == find(e[1])) continue;

            union(e[0], e[1]);
            sum += e[2];
            cnt++;

            if (cnt == n - 1) break;
        }

        return sum;
    }
}
