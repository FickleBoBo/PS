package day_08.boj_1629;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(modPow(a, b, c));
    }

    static long modPow(long a, long b, long c) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) > 0) res = res * a % c;
            a = a * a % c;
            b >>= 1;
        }

        return res;
    }
}
