package day_14.BOJ_2231;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            int sum = solve(i);

            if (sum == N) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

    private static int solve(int N) {
        int sum = N;

        while (N != 0) {
            sum += N % 10;
            N /= 10;
        }

        return sum;
    }

}
