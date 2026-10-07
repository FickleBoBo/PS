package day_02.boj_5597;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] vis = new boolean[1 + 30];
        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            vis[n] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (vis[i]) continue;
            System.out.println(i);
        }
    }
}
