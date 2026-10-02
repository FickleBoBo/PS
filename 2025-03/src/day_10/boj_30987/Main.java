package day_10.BOJ_30987;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        b -= d;
        c -= e;

        System.out.println(calculate(a, b, c, x2) - calculate(a, b, c, x1));
    }

    private static int calculate(int a, int b, int c, int x) {
        return (int) (Math.pow(x, 3) * a / 3 + Math.pow(x, 2) * b / 2 + x * c);
    }

}
