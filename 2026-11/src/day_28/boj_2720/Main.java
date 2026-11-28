package day_28.boj_2720;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int c = Integer.parseInt(br.readLine());

            sb.append(c / 25).append(" ");
            c %= 25;

            sb.append(c / 10).append(" ");
            c %= 10;

            sb.append(c / 5).append(" ");
            c %= 5;

            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }
}
