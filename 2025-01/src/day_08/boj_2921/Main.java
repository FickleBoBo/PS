package day_08.BOJ_2921;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                ans += i + j;
            }
        }

        System.out.println(ans);
    }
}
