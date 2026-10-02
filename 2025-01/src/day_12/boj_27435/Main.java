package day_12.BOJ_27435;

import java.io.*;

public class Main {

    // 점화식의 기본 행렬
    private static final long[][] baseMatrix = {
            {0, 1, 1},
            {1, 0, 0},
            {0, 1, 0}
    };

    private static final int MOD = 998_244_353;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());
            sb.append(solve(N)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static long solve(long N) {
        if (N <= 3) return 1;

        long[][] matrix = recur(N - 3);

        // a1 = 1, a2 = 1, a3 = 1
        return (matrix[0][0] + matrix[0][1] + matrix[0][2]) % MOD;
    }

    // 행렬의 거듭제곱을 반환하는 메서드
    private static long[][] recur(long N) {
        if (N == 1) return baseMatrix;

        long[][] half = recur(N / 2);

        if (N % 2 == 0) return mul(half, half);
        else return mul(half, mul(half, baseMatrix));
    }

    // 두 행렬의 곱을 반환하는 메서드
    private static long[][] mul(long[][] matrix1, long[][] matrix2) {
        long[][] ans = new long[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    ans[i][j] += (matrix1[i][k] * matrix2[k][j]) % MOD;
                }
            }
        }

        return ans;
    }

}
