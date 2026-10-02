package day_13.BOJ_20056;

import java.io.*;
import java.util.*;

public class Main {

    private static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    private static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<FireBall>[][] map = new ArrayDeque[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayDeque<>();
            }
        }

        Queue<FireBall> fireballs = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            move(fireballs, map, N);
        }

        int sum = 0;
        while (!fireballs.isEmpty()) {
            sum += fireballs.remove().m;
        }

        System.out.println(sum);
    }

    private static void move(Queue<FireBall> q, Queue<FireBall>[][] map, int N) {
        int len = q.size();
        for (int i = 0; i < len; i++) {
            FireBall fb = q.remove();

            int nr = (fb.r + dr[fb.d] * fb.s + N * 1000) % N;
            int nc = (fb.c + dc[fb.d] * fb.s + N * 1000) % N;

            map[nr][nc].add(new FireBall(nr, nc, fb.m, fb.s, fb.d));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() == 1) {
                    q.add(map[i][j].remove());
                } else if (map[i][j].size() > 1) {
                    int cnt = map[i][j].size();
                    int nm = 0;
                    int ns = 0;
                    boolean isSameDir = true;
                    int beforeDir = map[i][j].peek().d;

                    while (!map[i][j].isEmpty()) {
                        FireBall fb = map[i][j].remove();

                        nm += fb.m;
                        ns += fb.s;
                        if (beforeDir % 2 != fb.d % 2) isSameDir = false;
                        beforeDir = fb.d;
                    }

                    nm /= 5;
                    ns /= cnt;

                    if (nm == 0) continue;

                    if (isSameDir) {
                        for (int dir = 0; dir < 8; dir += 2) {
                            q.add(new FireBall(i, j, nm, ns, dir));
                        }
                    } else {
                        for (int dir = 0; dir < 8; dir += 2) {
                            q.add(new FireBall(i, j, nm, ns, dir + 1));
                        }
                    }
                }
            }
        }
    }

}
