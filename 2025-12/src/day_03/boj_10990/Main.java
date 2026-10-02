package day_03.boj_10990;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            sb.repeat(" ", n - i);

            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
