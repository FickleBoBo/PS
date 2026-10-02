package day_30.BOJ_2476;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == B && A == C) max = Math.max(max, 10000 + 1000 * A);
            else if (A == B) max = Math.max(max, 1000 + 100 * A);
            else if (B == C) max = Math.max(max, 1000 + 100 * B);
            else if (C == A) max = Math.max(max, 1000 + 100 * C);
            else max = Math.max(max, 100 * Math.max(A, Math.max(B, C)));
        }

        System.out.println(max);
    }
}
