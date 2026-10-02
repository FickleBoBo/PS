package day_08.BOJ_25703;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append("int a;\n");
        for (int i = 1; i <= N; i++) {
            sb.append("int ");

            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append("ptr");

            if (i == 1) sb.append(" = &a");
            else sb.append(i).append(" = &ptr");

            if (i > 2) sb.append(i - 1);

            sb.append(";\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
