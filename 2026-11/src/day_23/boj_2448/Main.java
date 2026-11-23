package day_23.boj_2448;

import java.io.*;

public class Main {

    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        vis = new boolean[n][n * 2];

        dfs(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2; j++) {
                if (vis[i][j]) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.newLine();
        }

        bw.flush();
    }

    static void dfs(int sr, int sc, int n) {
        if (n == 3) {
            vis[sr][sc + 2] = true;
            vis[sr + 1][sc + 1] = true;
            vis[sr + 1][sc + 3] = true;
            vis[sr + 2][sc] = true;
            vis[sr + 2][sc + 1] = true;
            vis[sr + 2][sc + 2] = true;
            vis[sr + 2][sc + 3] = true;
            vis[sr + 2][sc + 4] = true;
            return;
        }

        dfs(sr, sc + n / 2, n / 2);
        dfs(sr + n / 2, sc, n / 2);
        dfs(sr + n / 2, sc + n, n / 2);
    }
}
