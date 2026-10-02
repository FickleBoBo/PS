package day_05.BOJ_2444;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int pivot = N - 1;
        for (int i = 1; i <= 2 * N - 1; i++) {
            for (int j = 1; j <= pivot; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= 2 * (N - pivot) - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");

            if (i < N) pivot--;
            else pivot++;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
