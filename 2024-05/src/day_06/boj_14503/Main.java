package day_06.BOJ_G5_14503;

import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;

        out:
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                cnt++;
            }

            if (map[r][c] == 2) {
                for (int dir = 0; dir < 4; dir++) {
                    int nd = (d - dir + 3) % 4;
                    int nr = r + dr[nd];
                    int nc = c + dc[nd];
                    if (map[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        d = nd;
                        continue out;
                    }
                }
                r += dr[(d + 2) % 4];
                c += dc[(d + 2) % 4];
            }
            else if (map[r][c] == 1) break;
        }

        System.out.println(cnt);

    }
}