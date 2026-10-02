package day_05.BOJ_1193;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());

        int N = 0;
        while (N * (N + 1) / 2 < X) {
            N++;
        }

        int sum = N * (N + 1) / 2;
        if (N % 2 == 0) sb.append(N - sum + X).append("/").append(sum - X + 1);
        else sb.append(sum - X + 1).append("/").append(N - sum + X);

        bw.write(sb.toString());
        bw.flush();
    }
}
