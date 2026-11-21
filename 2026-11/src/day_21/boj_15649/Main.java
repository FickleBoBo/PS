package day_21.boj_15649;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] sel;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sel = new int[m];
        vis = new boolean[1 + n];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int x : sel) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;

            sel[depth] = i;
            vis[i] = true;
            dfs(depth + 1);
            vis[i] = false;
        }
    }
}
