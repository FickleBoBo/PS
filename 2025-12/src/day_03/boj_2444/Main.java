package day_03.boj_2444;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int l = n;
        int r = n;
        for (int i = 1; i <= 2 * n - 1; i++) {
            sb.repeat(" ", l - 1);
            sb.repeat("*", r - l + 1);
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
