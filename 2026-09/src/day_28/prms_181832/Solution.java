package day_28.prms_181832;

class Solution {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public int[][] solution(int n) {
        int[][] arr = new int[n][n];
        int r = 0, c = -1, d = 1, num = 1;

        while (num <= n * n) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            arr[nr][nc] = num++;
            r = nr;
            c = nc;
        }

        return arr;
    }
}
