package day_24.boj_3036;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n - 1; i++) {
            int r = Integer.parseInt(st.nextToken());
            int g = gcd(first, r);
            sb.append(first / g).append("/").append(r / g).append("\n");
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
