package day_03.boj_2522;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int pivot = n;
        for (int i = 1; i <= 2 * n - 1; i++) {
            sb.repeat(" ", pivot - 1);
            sb.repeat("*", n - pivot + 1);
            sb.append("\n");

            if (i < n) {
                pivot--;
            } else {
                pivot++;
            }
        }

        System.out.println(sb);
    }
}
