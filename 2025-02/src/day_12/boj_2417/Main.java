package day_12.BOJ_2417;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long q = binarySearchLowerBound(N);
        System.out.println(q);
    }

    private static long binarySearchLowerBound(long N) {
        long low = 0;
        long high = (long) Math.sqrt(N) + 1;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (mid * mid < N) low = mid + 1;
            else high = mid;
        }

        return high;
    }

}
