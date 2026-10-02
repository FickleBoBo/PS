package day_04.BOJ_2010;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 1;
        for (int i = 0; i < N; i++) {
            ans += Integer.parseInt(br.readLine()) - 1;
        }

        System.out.println(ans);
    }
}
