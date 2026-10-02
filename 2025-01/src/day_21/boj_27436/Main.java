package day_21.BOJ_27436;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long ans = binarySearchLowerBound(N);

        System.out.println(ans);
    }

    private static long binarySearchLowerBound(long N) {
        long low = 1;
        long high = (long) (2 * 1e9);

        while (low < high) {
            long mid = low + (high - low) / 2;

            // 이동 횟수 mid에 대한 가장 큰 방 번호 공식
            long Sn = 3 * mid * (mid - 1) + 1;

            if (Sn < N) low = mid + 1;
            else high = mid;
        }

        return high;
    }

}
