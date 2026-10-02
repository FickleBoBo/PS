package day_10.BOJ_11721;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();

        for (int i = 0; i < N.length(); i++) {
            sb.append(N.charAt(i));

            if ((i + 1) % 10 == 0) sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
