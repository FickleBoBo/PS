package day_09.BOJ_1780;

import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map;
    private static int cntMinus = 0;
    private static int cntZero = 0;
    private static int cntPlus = 0;

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

        System.out.println(cntMinus);
        System.out.println(cntZero);
        System.out.println(cntPlus);
    }

    private static void recur(int r1, int c1, int r2, int c2) {
        if (isNotSame(r1, c1, r2, c2)) {
            int midR1 = r1 + (r2 - r1) / 3;
            int midC1 = c1 + (c2 - c1) / 3;
            int midR2 = r1 + (r2 - r1) / 3 * 2;
            int midC2 = c1 + (c2 - c1) / 3 * 2;

            recur(r1, c1, midR1, midC1);
            recur(r1, midC1, midR1, midC2);
            recur(r1, midC2, midR1, c2);
            recur(midR1, c1, midR2, midC1);
            recur(midR1, midC1, midR2, midC2);
            recur(midR1, midC2, midR2, c2);
            recur(midR2, c1, r2, midC1);
            recur(midR2, midC1, r2, midC2);
            recur(midR2, midC2, r2, c2);
        }
    }

    private static boolean isNotSame(int r1, int c1, int r2, int c2) {
        int num = map[r1][c1];

        for (int r = r1; r < r2; r++) {
            for (int c = c1; c < c2; c++) {
                if (map[r][c] != num) return true;
            }
        }

        if (num == -1) cntMinus++;
        else if (num == 1) cntPlus++;
        else cntZero++;

        return false;
    }

}
