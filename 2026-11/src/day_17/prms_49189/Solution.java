package day_17.prms_49189;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] adj = new ArrayList[1 + n];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] vis = new boolean[1 + n];
        vis[1] = true;

        int ans = 0;
        while (!q.isEmpty()) {
            ans = q.size();
            int sz = q.size();
            while (sz-- > 0) {
                int cur = q.poll();
                for (int nxt : adj[cur]) {
                    if (vis[nxt]) continue;
                    q.offer(nxt);
                    vis[nxt] = true;
                }
            }
        }

        return ans;
    }
}
