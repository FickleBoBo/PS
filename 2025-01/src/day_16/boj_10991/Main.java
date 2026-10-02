package day_16.BOJ_10991;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= 2 * i + 1; j++) {
                if (j % 2 == 0) sb.append(" ");
                else sb.append("*");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
