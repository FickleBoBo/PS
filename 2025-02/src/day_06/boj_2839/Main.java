package day_06.BOJ_2839;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int min = -1;

        out:
        for (int i = N / 5; i >= 0; i--) {
            for (int j = N / 3; j >= 0; j--) {
                if (i * 5 + j * 3 == N) {
                    min = i + j;
                    break out;
                }
            }
        }

        System.out.println(min);
    }
}
