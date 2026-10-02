package day_04.BOJ_1094;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 64; i >= 1; i /= 2) {
            if (X >= i) {
                X -= i;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
