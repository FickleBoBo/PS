package day_09.BOJ_1629;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(recur(A, B, C));
    }

    private static long recur(long A, long B, long C) {
        if (B == 1) return A % C;

        long half = recur(A, B / 2, C);

        if (B % 2 == 0) return half * half % C;
        else return half * half % C * A % C;
    }

}
