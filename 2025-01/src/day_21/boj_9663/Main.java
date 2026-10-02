package day_21.BOJ_9663;

import java.io.*;

public class Main {

    private static int N;
    private static boolean[] col;
    private static boolean[] d1;
    private static boolean[] d2;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 열에 대한 방문 체크 배열
        col = new boolean[N];

        // 우상좌하 대각선에 대한 방문 체크 배열
        d1 = new boolean[2 * N - 1];

        // 좌상우하 대각선에 대한 방문 체크 배열
        d2 = new boolean[2 * N - 1];

        solve(0);

        System.out.println(cnt);
    }

    // 순열 기반의 재귀 메서드로 selIdx 자체가 행에 대한 선택
    private static void solve(int selIdx) {
        if (selIdx == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (col[i] || d1[i + selIdx] || d2[N - 1 + i - selIdx]) continue;

            col[i] = true;
            d1[i + selIdx] = true;
            d2[N - 1 + i - selIdx] = true;

            solve(selIdx + 1);

            col[i] = false;
            d1[i + selIdx] = false;
            d2[N - 1 + i - selIdx] = false;
        }
    }

}
