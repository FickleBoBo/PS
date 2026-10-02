package day_04.BOJ_17386;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        if (cross(x1, y1, x2, y2, x3, y3, x4, y4) && cross(x3, y3, x4, y4, x1, y1, x2, y2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean cross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int vector123 = ccw(x1, y1, x2, y2, x3, y3);
        int vector124 = ccw(x1, y1, x2, y2, x4, y4);

        return vector123 * vector124 < 0;
    }

    // CCW 알고리즘
    private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        return ((x1 * y2 - x2 * y1) + (x2 * y3 - x3 * y2) + (x3 * y1 - x1 * y3)) > 0 ? 1 : -1;
    }

}
