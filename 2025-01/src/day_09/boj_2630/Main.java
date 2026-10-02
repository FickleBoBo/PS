package day_09.BOJ_2630;

import java.io.*;
import java.util.*;

public class Main {

    private static final int WHITE = 0;
    private static final int BLUE = 1;
    private static int whiteCnt = 0;
    private static int blueCnt = 0;

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, N, N);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void recur(int r1, int c1, int r2, int c2) {
        if (hasManyColor(r1, c1, r2, c2)) {
            int midR = (r1 + r2) / 2;
            int midC = (c1 + c2) / 2;

            recur(r1, c1, midR, midC);
            recur(r1, midC, midR, c2);
            recur(midR, c1, r2, midC);
            recur(midR, midC, r2, c2);
        }
    }

    private static boolean hasManyColor(int r1, int c1, int r2, int c2) {
        int color = map[r1][c1];

        for (int r = r1; r < r2; r++) {
            for (int c = c1; c < c2; c++) {
                if (map[r][c] != color) return true;
            }
        }

        if (color == WHITE) whiteCnt++;
        else if (color == BLUE) blueCnt++;

        return false;
    }

}
