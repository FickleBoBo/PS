package day_23.boj_2444;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int l = n, r = n;
        for (int i = 1; i <= 2 * n - 1; i++) {
            for (int j = 1; j < l; j++) {
                sb.append(" ");
            }
            for (int j = l; j <= r; j++) {
                sb.append("*");
            }
            sb.append("\n");

            if (i < n) {
                l--;
                r++;
            } else {
                l++;
                r--;
            }
        }

        System.out.println(sb);
    }
}
