package day_14.BOJ_12348;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        long len = input.length();

        long N = Long.parseLong(input);
        long ans = 0;

        for (long i = N - 9 * len; i <= N; i++) {
            long sum = solve(i);

            if (sum == N) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

    private static long solve(long N) {
        long sum = N;

        while (N != 0) {
            sum += N % 10;
            N /= 10;
        }

        return sum;
    }

}
