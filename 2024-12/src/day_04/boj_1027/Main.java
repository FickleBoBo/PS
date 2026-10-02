package day_04.BOJ_1027;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] cntArr = new int[N];

        for (int i = 0; i < N - 1; i++) {
            int xPivot = i;
            int yPivot = 0;

            for (int j = i + 1; j < N; j++) {
                if (!cross(i, heights[i], xPivot, yPivot, j, heights[j])) {
                    cntArr[i]++;
                    cntArr[j]++;
                    xPivot = j;
                    yPivot = heights[j];
                }
            }
        }

        int max = 0;
        for (int cnt : cntArr) {
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    private static boolean cross(int x1, int y1, int x2, int y2, int x3, int y3) {
        return ccw(x1, y1, x2, y2, x3, y3) <= 0;
    }

    // CCW 알고리즘
    private static long ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        return (x1 * y2 - x2 * y1) + (x2 * y3 - x3 * y2) + (x3 * y1 - x1 * y3);
    }

}
