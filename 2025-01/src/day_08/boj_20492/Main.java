package day_08.BOJ_20492;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(N * 78 / 100).append(" ").append(N * 80 / 100 + N * 20 / 100 * 78 / 100);

        bw.write(sb.toString());
        bw.flush();
    }
}
