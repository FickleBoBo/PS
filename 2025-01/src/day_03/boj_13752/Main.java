package day_03.BOJ_13752;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());

            for (int j = 0; j < K; j++) {
                bw.write("=");
            }
            bw.newLine();
        }

        bw.flush();
    }
}
