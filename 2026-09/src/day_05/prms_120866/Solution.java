package day_05.prms_120866;

class Solution {

    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] vis = new boolean[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 1) {
                    vis[r][c] = true;
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                        vis[nr][nc] = true;
                    }
                }
            }
        }

        int cnt = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!vis[r][c]) cnt++;
            }
        }

        return cnt;
    }
}
