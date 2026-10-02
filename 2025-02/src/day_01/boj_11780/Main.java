package day_01.BOJ_11780;

import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] dp = new int[1 + N][1 + N];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        int[][] before = new int[1 + N][1 + N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (dp[A][B] > C) {
                dp[A][B] = C;
                before[A][B] = A;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        before[i][j] = before[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dp[i][j] == INF) sb.append("0 ");
                else sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dp[i][j] == INF || i == j) sb.append("0\n");
                else sb.append(find(i, j, before[i][j], before));
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String find(int start, int end, int cur, int[][] before) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(end);
        while (cur != 0) {
            stack.push(cur);
            cur = before[start][cur];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stack.size()).append(" ");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        sb.append("\n");

        return sb.toString();
    }

}
