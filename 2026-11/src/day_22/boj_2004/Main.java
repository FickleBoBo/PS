package day_22.boj_2004;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt2 = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);
        int cnt5 = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);
        System.out.println(Math.min(cnt2, cnt5));
    }

    static int countFactor(int x, int div) {
        int cnt = 0;
        while (x > 0) {
            x /= div;
            cnt += x;
        }

        return cnt;
    }
}
