package day_03.boj_2442;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            sb.repeat(" ", n - i);
            sb.repeat("*", 2 * i - 1);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
