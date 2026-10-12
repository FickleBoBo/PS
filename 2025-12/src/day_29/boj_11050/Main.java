package day_29.boj_11050;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(comb(n, k));
    }

    static int comb(int n, int r) {
        if (r == 0 || n == r) return 1;
        if (r == 1) return n;
        return comb(n - 1, r) + comb(n - 1, r - 1);
    }
}
