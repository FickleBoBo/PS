package day_04.BOJ_14248;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static int N;
    private static int[] jump;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        jump = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            jump[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];

        int S = Integer.parseInt(br.readLine()) - 1;

        int cnt = dfs(S);
        System.out.println(cnt);
    }

    private static int dfs(int node) {
        visited[node] = true;
        int cnt = 1;

        int jumpLeft = node - jump[node];
        if (jumpLeft >= 0 && !visited[jumpLeft]) {
            cnt += dfs(jumpLeft);
        }

        int jumpRight = node + jump[node];
        if (jumpRight < N && !visited[jumpRight]) {
            cnt += dfs(jumpRight);
        }

        return cnt;
    }

}
