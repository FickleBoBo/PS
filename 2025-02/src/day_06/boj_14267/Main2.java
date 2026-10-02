package day_06.BOJ_14267;

import java.io.*;
import java.util.*;

public class Main_DP2 {

    private static final List<List<Integer>> adj = new ArrayList<>();
    private static int[] arr;
    private static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            adj.get(parent).add(i);
        }

        // 칭찬을 받기 시작한 첫번째 직원에 칭찬의 수치 저장
        arr = new int[1 + N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[num] += w;
        }

        ans = new int[1 + N];

        dfs(1, arr[1]);

        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int node, int sum) {
        ans[node] = sum;
        for (int next : adj.get(node)) {
            dfs(next, sum + arr[next]);
        }
    }

}
