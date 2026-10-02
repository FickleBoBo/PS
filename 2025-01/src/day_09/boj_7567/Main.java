package day_09.BOJ_7567;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        int ans = 0;
        char last = ' ';
        for (char c : input) {
            if (c == last) ans += 5;
            else ans += 10;

            last = c;
        }

        System.out.println(ans);
    }
}
