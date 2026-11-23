package day_23.boj_9316;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            sb.append("Hello World, Judge ").append(i).append("!\n");
        }

        System.out.println(sb);
    }
}
