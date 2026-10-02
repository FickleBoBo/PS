package day_05.BOJ_17427;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += N / i * i;
        }

        System.out.println(sum);
    }
}
