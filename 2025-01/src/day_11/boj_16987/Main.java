package day_11.BOJ_16987;

import java.io.*;
import java.util.*;

public class Main {

    private static class Egg {
        int S;
        int W;

        public Egg(int S, int W) {
            this.S = S;
            this.W = W;
        }
    }

    private static Egg[] eggs;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(S, W);
        }

        solve(0, 0);

        System.out.println(ans);
    }

    // 중복 순열 기반 재귀 함수
    private static void solve(int selIdx, int cnt) {

        // 가장 오른쪽 계란까지 손에 든 이후인 경우 || 가장 오른쪽 계란이 칠 계란이 없는 경우
        if (selIdx == eggs.length || cnt == eggs.length - 1) {
            ans = Math.max(ans, cnt);
            return;
        }

        // 손에 들 계란이 깨진 계란인 경우
        if (eggs[selIdx].S <= 0) {
            solve(selIdx + 1, cnt);
            return;
        }

        for (int i = 0; i < eggs.length; i++) {

            // 손에 든 계란이랑 칠 계란이 동일한 경우
            if (selIdx == i) continue;

            // 칠 계란이 깨진 계란인 경우
            if (eggs[i].S <= 0) continue;

            // 계란 치기
            eggs[selIdx].S -= eggs[i].W;
            eggs[i].S -= eggs[selIdx].W;

            if (eggs[selIdx].S <= 0 && eggs[i].S <= 0) solve(selIdx + 1, cnt + 2);
            else if (eggs[selIdx].S <= 0 || eggs[i].S <= 0) solve(selIdx + 1, cnt + 1);
            else solve(selIdx + 1, cnt);

            // 계란 복구하기
            eggs[selIdx].S += eggs[i].W;
            eggs[i].S += eggs[selIdx].W;
        }
    }

}
