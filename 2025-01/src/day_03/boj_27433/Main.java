package day_03.BOJ_27433;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
        }

        System.out.println(ans);
    }
}
