package day_28.boj_12779;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long cnt = upperBound(b) - upperBound(a);

        if (cnt == 0) {
            System.out.println(0);
        } else {
            long g = gcd(cnt, b - a);
            System.out.printf("%d/%d", cnt / g, (b - a) / g);
        }
    }

    static long upperBound(long key) {
        long lo = 0, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid <= key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
