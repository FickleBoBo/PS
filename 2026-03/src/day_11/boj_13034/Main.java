package day_11.boj_13034;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] g = new int[1 + n];
        boolean[] seen = new boolean[16];  // 전처리로 미리 크기 계산
        for (int i = 2; i <= n; i++) {
            Arrays.fill(seen, false);
            for (int j = 0; j <= (i - 1) / 2; j++) {
                seen[g[j] ^ g[i - 2 - j]] = true;
            }

            int mex = 0;
            while (seen[mex]) {
                mex++;
            }
            g[i] = mex;
        }

        if (g[n] != 0) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
