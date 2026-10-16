package day_10.boj_16877;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 3_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] fibo = new int[32];  // 전처리로 미리 크기 계산
        fibo[0] = fibo[1] = 1;
        for (int i = 2; i < 32; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        int[] g = new int[1 + MAX];
        boolean[] seen = new boolean[16];  // 전처리로 미리 크기 계산
        for (int i = 1; i <= MAX; i++) {
            Arrays.fill(seen, false);
            for (int x : fibo) {
                if (i >= x) seen[g[i - x]] = true;
            }

            int mex = 0;
            while (seen[mex]) {
                mex++;
            }
            g[i] = mex;
        }

        int nimsum = 0;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int p = Integer.parseInt(st.nextToken());
            nimsum ^= g[p];
        }

        if (nimsum != 0) {
            System.out.println("koosaga");
        } else {
            System.out.println("cubelover");
        }
    }
}
