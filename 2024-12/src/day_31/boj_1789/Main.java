package day_31.BOJ_1789;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        long n = 1;
        while (n * (n + 1) / 2 <= S) {
            n++;
        }

        System.out.println(n - 1);
    }
}
