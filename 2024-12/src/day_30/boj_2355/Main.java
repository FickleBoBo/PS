package day_30.BOJ_2355;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long sum = (A + B) * (Math.max(A, B) - Math.min(A, B) + 1) / 2;

        System.out.println(sum);
    }
}
