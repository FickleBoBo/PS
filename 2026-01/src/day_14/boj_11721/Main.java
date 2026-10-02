package day_14.boj_11721;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && i % 10 == 0) {
                sb.append("\n");
            }

            sb.append(s.charAt(i));
        }

        System.out.println(sb);
    }
}
