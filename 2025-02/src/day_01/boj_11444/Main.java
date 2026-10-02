package day_01.BOJ_11444;

import java.io.*;

public class Main {

    private static final long[][] baseMatrix = {
            {1, 1},
            {1, 0}
    };

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        int ans = solve(N);
        System.out.println(ans);
    }

    private static int solve(long N) {
        if (N <= 2) return 1;

        long[][] matrix = recur(N - 2);
        return (int) ((matrix[0][0] + matrix[0][1]) % MOD);
    }

    private static long[][] recur(long N) {
        if (N == 1) return baseMatrix;

        long[][] half = recur(N / 2);

        if (N % 2 == 0) return mul(half, half);
        else return mul(half, mul(half, baseMatrix));
    }

    private static long[][] mul(long[][] m1, long[][] m2) {
        return new long[][]{
                {(m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]) % MOD, (m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]) % MOD},
                {(m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]) % MOD, (m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]) % MOD}
        };
    }

}
