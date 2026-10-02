package day_07.BOJ_10162;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        if (T % 10 != 0) sb.append(-1);
        else sb.append(T / 300).append(" ").append(T % 300 / 60).append(" ").append(T % 60 / 10);

        bw.write(sb.toString());
        bw.flush();
    }
}
