package day_04.BOJ_1497;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static char[][] status;
    private static boolean[] visited;
    private static int maxCnt = 0;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        status = new char[N][M];

        char[] maxStatus = new char[M];
        Arrays.fill(maxStatus, 'N');

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            status[i] = st.nextToken().toCharArray();

            for (int j = 0; j < M; j++) {
                if (status[i][j] == 'Y') maxStatus[j] = 'Y';
            }
        }

        for (char c : maxStatus) {
            if (c == 'Y') maxCnt++;
        }

        visited = new boolean[N];

        powerSet(0);

        if (ans == 0) System.out.println(-1);
        else System.out.println(ans);
    }

    private static void powerSet(int selIdx) {
        if (selIdx == N) {
            char[] tmpStatus = new char[M];
            Arrays.fill(tmpStatus, 'N');

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    for (int j = 0; j < M; j++) {
                        if (status[i][j] == 'Y') tmpStatus[j] = 'Y';
                    }
                }
            }

            int cnt = 0;
            for (char c : tmpStatus) {
                if (c == 'Y') cnt++;
            }

            if (cnt == maxCnt) {
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    if (visited[i]) sum++;
                }

                ans = Math.min(ans, sum);
            }

            return;
        }

        visited[selIdx] = true;
        powerSet(selIdx + 1);

        visited[selIdx] = false;
        powerSet(selIdx + 1);
    }

}
