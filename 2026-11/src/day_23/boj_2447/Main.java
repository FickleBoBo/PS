package day_23.boj_2447;

import java.io.*;

public class Main {

    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        vis = new boolean[n][n];

        dfs(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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
        if (n == 1) {
            vis[sr][sc] = true;
            return;
        }

        dfs(sr, sc, n / 3);
        dfs(sr, sc + n / 3, n / 3);
        dfs(sr, sc + n / 3 * 2, n / 3);
        dfs(sr + n / 3, sc, n / 3);
        dfs(sr + n / 3, sc + n / 3 * 2, n / 3);
        dfs(sr + n / 3 * 2, sc, n / 3);
        dfs(sr + n / 3 * 2, sc + n / 3, n / 3);
        dfs(sr + n / 3 * 2, sc + n / 3 * 2, n / 3);
    }
}
