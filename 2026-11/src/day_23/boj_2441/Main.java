package day_23.boj_2441;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= n - i + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
