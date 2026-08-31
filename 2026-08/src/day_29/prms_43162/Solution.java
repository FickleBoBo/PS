package day_29.prms_43162;

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] vis = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            bfs(i, n, computers, vis);
            cnt++;
        }

        return cnt;
    }

    static void bfs(int start, int n, int[][] computers, boolean[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        vis[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt = 0; nxt < n; nxt++) {
                if (computers[cur][nxt] == 0 || vis[nxt]) continue;
                q.offer(nxt);
                vis[nxt] = true;
            }
        }
    }
}
