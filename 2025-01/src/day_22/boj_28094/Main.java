package day_22.BOJ_28094;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static boolean[] visited;
    private static int[] sel;

    private static int[][] map;

    private static int max;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            map = new int[1 + N][1 + N];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                map[A][B] += V;
            }

            visited = new boolean[1 + N];
            sel = new int[1 + N];
            max = 0;
            cnt = 0;

            permutation(1);

            sb.append(max).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void permutation(int selIdx) {
        if (selIdx == sel.length) {
            int sum = 0;

            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {
                    sum += map[sel[i]][sel[j]];
                }
            }

            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) {
                cnt++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            sel[selIdx] = i;
            visited[i] = true;
            permutation(selIdx + 1);
            visited[i] = false;
        }
    }

}
