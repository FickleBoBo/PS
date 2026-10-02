package day_10.BOJ_9466;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static int[] adj;
    private static boolean[] visited;  // 임시 방문 체크 배열
    private static boolean[] finished;  // 방문 체크 배열
    private static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            adj = new int[1 + N];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                adj[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[1 + N];
            finished = new boolean[1 + N];
            sum = 0;
            for (int i = 1; i <= N; i++) {
                dfs(i);
            }

            sb.append(N - sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int node) {
        if (finished[node]) return;

        // 임시 방문한 노드를 다시 방문하면 사이클을 발견한 경우고 해당 위치는 사이클의 일부가 됨
        if (visited[node]) {
            cycle(node);
            return;
        }

        visited[node] = true;  // 현재 노드 임시 방문 체크
        dfs(adj[node]);
        finished[node] = true;  // 탐색 종료 후 방문 체크
    }

    // 방문 체크와 사이클 크기 계산
    private static void cycle(int node) {
        if (finished[node]) return;

        finished[node] = true;
        sum++;
        cycle(adj[node]);
    }

}
