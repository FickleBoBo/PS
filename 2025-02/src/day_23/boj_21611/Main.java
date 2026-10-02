package day_23.BOJ_21611;

import java.io.*;
import java.util.*;

public class Main {

    // d를 델다 배열의 인덱스로 변환해주는 배열
    private static final int[] dArr = {-1, 3, 1, 0, 2};

    // 좌 하 우 상 델타 배열
    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {-1, 0, 1, 0};

    // 폭발한 구슬의 수를 세는 카운팅 배열
    private static final int[] cntArr = new int[1 + 3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = dArr[Integer.parseInt(st.nextToken())];
            int s = Integer.parseInt(st.nextToken());

            // 마법에 대해 구슬의 파괴를 시작으로 이동과 폭발을 반복
            destroy(d, s, N, map);
        }

        System.out.println(cntArr[1] + cntArr[2] * 2 + cntArr[3] * 3);
    }

    private static void destroy(int d, int s, int N, int[][] map) {
        for (int i = 1; i <= s; i++) {
            int nr = N / 2 + dr[d] * i;
            int nc = N / 2 + dc[d] * i;

            map[nr][nc] = 0;
        }

        // 구슬을 파괴 후 재배치
        Queue<Integer> q = makeNumQueue(N, map);
        move(q, N, map);

        // 더 이상 폭발하지 않을 때까지 폭발과 재배치 반복
        while (true) {
            boolean flag = explode(N, map);
            if (!flag) break;
        }

        // 구슬이 변화하는 단계
        change(N, map);
    }

    private static Queue<Integer> makeNumQueue(int N, int[][] map) {
        Queue<Integer> q = new ArrayDeque<>();

        int r = N / 2;
        int c = N / 2 - 1;
        int d = 1;

        int cnt = 0;
        int check = 1;
        int len = 1;

        while (c != -1) {
            if (map[r][c] != 0) q.add(map[r][c]);

            if (cnt == len) {
                check++;
                cnt = 0;
                d = (d + 1) % 4;
            }

            if (check == 2) {
                len++;
                check = 0;
            }

            r += dr[d];
            c += dc[d];
            cnt++;
        }

        return q;
    }

    private static void move(Queue<Integer> q, int N, int[][] map) {
        int r = N / 2;
        int c = N / 2 - 1;
        int d = 1;

        int cnt = 0;
        int check = 1;
        int len = 1;

        while (c != -1) {
            if (q.isEmpty()) map[r][c] = 0;
            else map[r][c] = q.remove();

            if (cnt == len) {
                check++;
                cnt = 0;
                d = (d + 1) % 4;
            }

            if (check == 2) {
                len++;
                check = 0;
            }

            r += dr[d];
            c += dc[d];
            cnt++;
        }
    }

    private static boolean explode(int N, int[][] map) {
        Deque<Integer> dq = new ArrayDeque<>();

        int r = N / 2;
        int c = N / 2 - 1;
        int d = 1;

        int cnt = 0;
        int check = 1;
        int len = 1;

        int before = 0;
        int beforeCnt = 0;

        boolean flag = false;

        while (c != -1) {
            if (before == map[r][c]) {
                dq.addLast(map[r][c]);
                beforeCnt++;
            } else {
                if (beforeCnt >= 4) {
                    flag = true;

                    for (int i = 0; i < beforeCnt; i++) {
                        cntArr[dq.removeLast()]++;
                    }
                }

                beforeCnt = 1;
                before = map[r][c];
                dq.addLast(map[r][c]);
            }

            if (cnt == len) {
                check++;
                cnt = 0;
                d = (d + 1) % 4;
            }

            if (check == 2) {
                len++;
                check = 0;
            }

            r += dr[d];
            c += dc[d];
            cnt++;
        }

        if (!flag) return false;

        move(dq, N, map);

        return true;
    }

    private static void change(int N, int[][] map) {
        Deque<Integer> dq = new ArrayDeque<>();

        int r = N / 2;
        int c = N / 2 - 1;
        int d = 1;

        int cnt = 0;
        int check = 1;
        int len = 1;

        int before = 0;
        int beforeCnt = 0;

        while (c != -1) {
            if (before == map[r][c]) {
                dq.addLast(map[r][c]);
                beforeCnt++;
            } else {
                for (int i = 0; i < beforeCnt; i++) {
                    dq.removeLast();
                }

                if (before != 0) {
                    dq.addLast(beforeCnt);
                    dq.addLast(before);
                }

                beforeCnt = 1;
                before = map[r][c];
                dq.addLast(map[r][c]);
            }

            if (cnt == len) {
                check++;
                cnt = 0;
                d = (d + 1) % 4;
            }

            if (check == 2) {
                len++;
                check = 0;
            }

            r += dr[d];
            c += dc[d];
            cnt++;
        }

        move(dq, N, map);
    }

}
