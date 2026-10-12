package day_08.boj_1629;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(modPow(a, b, c));
    }

    static long modPow(long a, long b, long c) {
        if (b == 0) return 1;

        long half = modPow(a, b / 2, c);
        if (b % 2 != 0) {
            return half * half % c * a % c;
        } else {
            return half * half % c;
        }
    }
}
