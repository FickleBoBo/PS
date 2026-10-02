package day_05.BOJ_2445;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 2 * N - 1;
        for (int i = 1; i <= 2 * N - 1; i++) {
            for (int j = 1; j <= left; j++) {
                sb.append("*");
            }
            for (int j = left; j < right; j++) {
                sb.append(" ");
            }
            for (int j = right; j < 2 * N; j++) {
                sb.append("*");
            }
            sb.append("\n");

            if (i < N) {
                left++;
                right--;
            } else {
                left--;
                right++;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
