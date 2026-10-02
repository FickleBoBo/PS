package day_01.BOJ_4458;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            sb.append(Character.toUpperCase(input.charAt(0))).append(input.substring(1)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
