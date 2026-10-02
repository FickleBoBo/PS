package day_06.BOJ_2292;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int n = 1;
        while ((3 * n * (n - 1) + 1) < N) {
            n++;
        }

        System.out.println(n);
    }
}
