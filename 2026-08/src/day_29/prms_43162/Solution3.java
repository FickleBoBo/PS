package day_29.prms_43162;

class Solution3 {

    static int[] p;

    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        p[x] = y;
        return true;
    }

    public int solution(int n, int[][] computers) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) union(i, j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == p[i]) cnt++;
        }

        return cnt;
    }
}
