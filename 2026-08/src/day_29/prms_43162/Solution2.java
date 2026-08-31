package day_29.prms_43162;

class Solution2 {
    public int solution(int n, int[][] computers) {
        boolean[] vis = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            dfs(i, n, computers, vis);
            cnt++;
        }

        return cnt;
    }

    static void dfs(int cur, int n, int[][] computers, boolean[] vis) {
        vis[cur] = true;

        for (int nxt = 0; nxt < n; nxt++) {
            if (computers[cur][nxt] == 0 || vis[nxt]) continue;
            dfs(nxt, n, computers, vis);
        }
    }
}
