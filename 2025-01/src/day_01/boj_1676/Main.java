package day_01.BOJ_1676;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 125 == 0) cnt += 3;
            else if (i % 25 == 0) cnt += 2;
            else if (i % 5 == 0) cnt += 1;
        }

        System.out.println(cnt);
    }
}
