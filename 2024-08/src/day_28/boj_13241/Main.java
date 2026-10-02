package day_28.BOJ_S5_13241;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(LCM(A, B));
    }

    private static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }

    // int 형 범위를 넘을 수 있다
    private static long LCM(int a, int b){
        int gcd = GCD(a, b);
        return (long) a * b / gcd;
    }

}
