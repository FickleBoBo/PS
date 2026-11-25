package day_24.boj_2476;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == b && b == c) {
                max = Math.max(max, 10000 + a * 1000);
            } else if (a == b) {
                max = Math.max(max, 1000 + a * 100);
            } else if (b == c) {
                max = Math.max(max, 1000 + b * 100);
            } else if (c == a) {
                max = Math.max(max, 1000 + c * 100);
            } else {
                max = Math.max(max, Math.max(a, Math.max(b, c)) * 100);
            }
        }

        System.out.println(max);
    }
}
