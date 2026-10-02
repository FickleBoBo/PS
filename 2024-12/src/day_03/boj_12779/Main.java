package day_03.BOJ_12779;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long N = 0;
        for (long i = (long) Math.sqrt(A); i * i <= B; i++) {
            if (A < i * i && i * i <= B) N++;
        }

        if (N == 0) {
            sb.append(0);
        } else {
            long gcd = gcd(N, B - A);
            sb.append(N / gcd).append("/").append((B - A) / gcd);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
