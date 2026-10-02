package day_15.BOJ_8320;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i * i <= N; i++) {
            for (int j = i; i * j <= N; j++) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
