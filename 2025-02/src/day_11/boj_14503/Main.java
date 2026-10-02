package day_11.BOJ_14503;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        if (d == 1) d = 3;
        else if (d == 3) d = 1;

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        out:
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                cnt++;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[(d + 1 + dir) % 4];
                int nc = c + dc[(d + 1 + dir) % 4];

                if (map[nr][nc] != 0) continue;

                r = nr;
                c = nc;
                d = (d + 1 + dir) % 4;
                continue out;
            }

            if (map[r - dr[d]][c - dc[d]] == 1) {
                break;
            } else {
                r -= dr[d];
                c -= dc[d];
            }
        }

        System.out.println(cnt);
    }
}
