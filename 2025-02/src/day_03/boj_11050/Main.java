package day_03.BOJ_11050;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = recur(N, K);
        System.out.println(ans);
    }

    private static int recur(int N, int K) {
        if (K == 1) return N;
        if (K == 0 || N == K) return 1;
        return recur(N - 1, K - 1) + recur(N - 1, K);
    }

}
