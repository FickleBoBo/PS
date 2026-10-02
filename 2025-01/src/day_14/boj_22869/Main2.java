package day_14.BOJ_22869;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static int N;
    private static int K;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[1 + N];

        dfs(1);

        if (visited[N]) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void dfs(int cur) {
        if (visited[cur]) return;
        visited[cur] = true;

        for (int next = cur + 1; next <= N; next++) {
            if ((next - cur) * (1 + Math.abs(arr[cur] - arr[next])) <= K) {
                dfs(next);
            }
        }
    }

}
