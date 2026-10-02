package day_11.BOJ_1074;

import java.io.*;
import java.util.*;

public class Main {

    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(2, N);
        long size = (long) len * len;

        recur(0, 0, len, len, 0, size);
    }

    private static void recur(int r1, int c1, int r2, int c2, long ans, long size) {
        if (r1 == r && c1 == c) {
            System.out.println(ans);
            return;
        }

        int midR = (r1 + r2) / 2;
        int midC = (c1 + c2) / 2;

        if (r < midR) {
            if (c < midC) recur(r1, c1, midR, midC, ans, size / 4);
            else recur(r1, midC, midR, c2, ans + size / 4, size / 4);
        } else {
            if (c < midC) recur(midR, c1, r2, midC, ans + size / 4 * 2, size / 4);
            else recur(midR, midC, r2, c2, ans + size / 4 * 3, size / 4);
        }
    }

}
